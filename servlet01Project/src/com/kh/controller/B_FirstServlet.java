package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
// @WebServlet("/FirstServlet")
public class B_FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public B_FirstServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);

		request.setCharacterEncoding("utf-8");

		// 보내는 데이터가 text형식이고 html 파일이며 인코딩 UTF-8로 지정
		response.setContentType("text/html; charset=UTF-8");

		// println() 메서드로 전송할 문자열 데이터 작성
		PrintWriter pw = response.getWriter();

		if (session != null) {
			pw.write("<h1>" + session.getAttribute("id") + " 님 환영합니다!</h1>");
		}

		pw.println("doGet 성공!<br>");
		pw.println("<h1>접근한 URI : </h1>");
		pw.println(request.getRequestURI());

		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 보내는 데이터가 text형식이고 html 파일이며 인코딩 UTF-8로 지정
		response.setContentType("text/html; charset=UTF-8");

		// println() 메서드로 전송할 문자열 데이터 작성
		PrintWriter pw = response.getWriter();

		pw.println("doPost 성공!<br>");
		pw.println("<h1>접근한 URI : </h1>");
		pw.println(request.getRequestURI());

		pw.flush();
		pw.close();
	}

}
