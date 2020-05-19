package common.vo;

import com.oreilly.servlet.MultipartRequest;

public class UploadFile {

	private boolean isSuccess = false;
	private String orginalFileName;
	private String renameFileName;
	private String savePath;
	private MultipartRequest mrequest;

	public UploadFile() {
		super();
	}

	public UploadFile(boolean isSuccess, String orginalFileName, String renameFileName, String savePath,
			MultipartRequest mrequest) {
		super();
		this.isSuccess = isSuccess;
		this.orginalFileName = orginalFileName;
		this.renameFileName = renameFileName;
		this.savePath = savePath;
		this.mrequest = mrequest;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getOrginalFileName() {
		return orginalFileName;
	}

	public void setOrginalFileName(String orginalFileName) {
		this.orginalFileName = orginalFileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public MultipartRequest getMrequest() {
		return mrequest;
	}

	public void setMrequest(MultipartRequest mrequest) {
		this.mrequest = mrequest;
	}

}
