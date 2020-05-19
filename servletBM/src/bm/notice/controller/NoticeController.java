package bm.notice.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bm.member.model.vo.Member;
import bm.notice.model.service.NoticeService;
import bm.notice.model.vo.Notice;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;
import common.util.FileUtil;
import common.vo.UploadFile;

public class NoticeController implements Controller {

	NoticeService ns = new NoticeService();

	public ModelAndView noticeList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		int currentPage = 1;
		int cntPerPage = 5;
		//쿼리에 들어갈 orderby 절
		String orderby = "noticeno";

		if (request.getParameter("cPage") != null) {

			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {

			currentPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = ns.selectNoticeList(orderby, currentPage, cntPerPage);

		mav.addObject("paging", res.get("paging"));
		mav.addObject("ndata", res.get("nList"));
		mav.setView("board/boardList");

		return mav;

	}

	public ModelAndView noticeUpload(HttpServletRequest request) throws IOException {

		ModelAndView mav = new ModelAndView();

		Member m = (Member) request.getSession().getAttribute("loginInfo");

		String uploadFolder = "resources/upload";
		UploadFile file = new FileUtil().fileUpload(uploadFolder, request);

		if (file.isSuccess()) {

			Notice notice = new Notice();

			mav.addObject("alertMsg", "파일업로드가 성공하였습니다.");

			notice.setNoticeTitle(file.getMrequest().getParameter("noticeTitle"));
			notice.setNoticeContent(file.getMrequest().getParameter("noticeContent"));
			notice.setNoticeWriter(m.getM_id());
			notice.setOriginal_filepath(file.getOrginalFileName());
			notice.setRename_filepath(file.getRenameFileName());

			mav.setView("common/result");

			//더미데이터 작성코드
			/*	for(int i = 0; i < 50; i++) {
					notice.setNoticeTitle(i + "번째 게시물 입니다.");
					ns.noticeUpload(notice);
				}*/

			if (ns.noticeUpload(notice) > 0) {
				mav.addObject("alertMsg", "게시물이 등록되었습니다.");
				mav.addObject("url", "/servletBM/notice/noticelist.do");
				mav.setView("common/result");
			} else {
				mav.addObject("alertMsg", "게시물 등록이 실패했습니다..");
				mav.addObject("back", "back");
				mav.setView("common/result");
			}

		} else {
			mav.addObject("alertMsg", "파일업로드에 실패했습니다.");
			mav.addObject("back", "back");
			mav.setView("common/result");
		}

		return mav;
	}

	public ModelAndView notice(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setView("board/boardForm");
		return mav;
	}

	public ModelAndView noticeDetail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

		Notice notice = ns.selectNotice(noticeNo);
		mav.addObject("notice", notice);
		mav.setView("board/boardView");

		return mav;

	}

	public ModelAndView noticeDownload(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		//절대경로값 받아오기
		String readFolder = request.getSession().getServletContext().getRealPath("/resources/upload");
		String path = readFolder + "/" + request.getParameter("rfname");
		
		String ofname = request.getParameter("ofname");
		
		System.out.println(ofname);
		
		mav.addObject("path", path);
		mav.addObject("ofname", ofname);
		mav.setView("file");
		
		return mav;

	}

}
