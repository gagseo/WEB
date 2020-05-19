package bm.book.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bm.book.model.service.BookService;
import bm.book.model.vo.Book;
import common.exception.BMException;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

/**
 * @PackageName: bm.book.controller
 * @FileName : BookController.java
 * @Date : 2020. 4. 12.
 * @���α׷� ���� : ����ó��Ŭ����
 * @author 
 */
public class BookController implements Controller {

	BookService bs = new BookService();

	/**
	 * 1. MethodName : selectBookList
	 * 2. ClassName  : BookController.java
	 * 3. Comment    : ������Ϲ�ȯ
	 * 4. �ۼ���       : �ϸ�
	 * 5. �ۼ���       : 2020. 4. 12.
	 * @throws BMException 
	**/
	public ModelAndView selectBookList(HttpServletRequest request) throws BMException {

		ModelAndView mav = new ModelAndView();
		String title = request.getParameter("b_title");
		List<Book> res = bs.selectBookList(title);
		mav.addObject("booklist", res);
		mav.setView("book/booksearch");
		return mav;

	}

	/**
	 * 1. MethodName : selectBook
	 * 2. ClassName  : BookController.java
	 * 3. Comment    : 도서상세
	 * 4. 작성자		 : 하명도
	 * 5. 작성일		 : 2020. 4. 12.
	 * @throws BMException 
	**/
	public ModelAndView selectBook(HttpServletRequest request) throws BMException {

		ModelAndView mav = new ModelAndView();
		int b_bno = Integer.parseInt(request.getParameter("b_bno"));
		Map<String, String> res = new HashMap<String, String>();
		res = bs.selectBook(b_bno);
		System.out.println("controller :" + res);
		mav.addObject("book", res);
		mav.setView("book/bookDetail");
		return mav;
	}

	public ModelAndView innerSearchBook(HttpServletRequest request) throws BMException {

		ModelAndView mav = new ModelAndView();
		

		//배열 형태
		String[] bnoList = request.getParameterValues("bnoList");
		System.out.println(Arrays.toString(bnoList));
		String title = request.getParameter("title");
		String orderBy = request.getParameter("orderBy");

		Map<String, Object> commandMap = new HashMap<String, Object>();
		commandMap.put("bnoList", bnoList);
		commandMap.put("title", title);
		commandMap.put("orderBy", orderBy);
		
		List<Book> res = bs.selectInnerBookSearchList(commandMap);
		mav.addObject("booklist", res);
		mav.setView("book/booksearch");

		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
