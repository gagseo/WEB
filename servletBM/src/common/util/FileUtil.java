package common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.frontcontroller.ModelAndView;
import common.vo.UploadFile;

public class FileUtil {

	public UploadFile fileUpload(String uploadFolder, HttpServletRequest request) {

		UploadFile uploadFile = new UploadFile();
		// request를 MultipartRequest 객체로 변환
		// MultipartRequest객체가 생섬됨과 동시에 파일 업로드가 이루어 진다.

		//업로드할 파일의 용량 제한 : 10MB
		int maxSize = 1024 * 1024 * 10;

		// 덮어 씌워질 위험이 있어서 이름을 변경해준다
		String orginalFileName = "";
		String renameFileName = "";

		// 루트 절대경로
		String root = request.getServletContext().getRealPath("/");

		String savePath = root + uploadFolder;

		MultipartRequest mrequest;
		try {
			mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			orginalFileName = mrequest.getFilesystemName("noticeFile");
			if (orginalFileName != null) {

				String fileName = String.valueOf(new Date().getTime());
				renameFileName = fileName + orginalFileName.substring(orginalFileName.lastIndexOf("."));

				File originFile = new File(savePath + "\\" + orginalFileName);
				File renameFile = new File(savePath + "\\" + renameFileName);

				originFile.renameTo(renameFile);
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			}

			uploadFile.setSuccess(true);
			uploadFile.setOrginalFileName(orginalFileName);
			uploadFile.setRenameFileName(renameFileName);
			uploadFile.setSavePath(savePath);
			uploadFile.setMrequest(mrequest);
		} catch (IOException e) {
			e.printStackTrace();
			uploadFile.setSuccess(false);
			uploadFile.setOrginalFileName(orginalFileName);
		}
		return uploadFile;
	}

	public boolean fileDownload(ModelAndView mav, HttpServletResponse response) {

		boolean res = false;
		File downFile = new File((String) mav.getData().get("path"));
		String ofname = (String) mav.getData().get("ofname");
		ServletOutputStream downOutput;

		try {
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(ofname, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			downOutput = response.getOutputStream();
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
			int read = 0;
			while ((read = bin.read()) != -1) {
				downOutput.write(read);
				downOutput.flush();
			}
			downOutput.close();
			bin.close();
			res = true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

}
