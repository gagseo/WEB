package com.kh.jspPrac.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuOrderServlet
 */
// @WebServlet("/MenuOrderServlet")
public class MenuOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String[] menu = request.getParameterValues("menu");
		int price = 0;

		for (int i = 0; i < menu.length; i++) {
			switch (menu[i]) {
			case "피자":
				price += 27000;
				break;
			case "떡볶이":
				price += 6000;
				break;
			case "치킨":
				price += 20000;
				break;
			case "연어":
				price += 16000;
				break;
			}
		}

		request.setAttribute("price", price);
		request.setAttribute("menu", menu);

		RequestDispatcher view = request.getRequestDispatcher("views/menu/03_menuResult.jsp");

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
