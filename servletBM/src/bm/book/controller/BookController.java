package bm.book.controller;

import javax.servlet.http.HttpServletRequest;

import bm.book.model.service.BookService;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

public class BookController implements Controller {

	private BookService bs = new BookService();

	public ModelAndView bookSearch(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		String keyWord = request.getParameter("searchBook");

		//자료형 리스트다
		
		mav.addObject("searchList", bs.bookSearch(keyWord));
		mav.setView("book/booksearch");
		
		return mav;

	}
}
