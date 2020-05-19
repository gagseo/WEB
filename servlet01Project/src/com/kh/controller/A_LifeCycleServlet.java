package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class LifeCycleServlet
 */
// @WebServlet("/LifeCycleServlet")
public class A_LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int initCount = 1;
	private int doGetCount = 1;
	private int destroyCount = 1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public A_LifeCycleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {

		System.out.println("init메서드는 첫 요청 시 한번만 호출 됨 : " + initCount++);
	}

	public void destroy() {

		System.out.println("destroy메서드는 톰켓 종료 시 호출 됨 : " + destroyCount++);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session != null) {
			pw.write("<h1>" + session.getAttribute("id") + " 님 환영합니다!</h1>");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("doGet메서드는 Get방식으로 요청이 올때 마다 호출 됨 : " + doGetCount++);
		
		
		
		
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
