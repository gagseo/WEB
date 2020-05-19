package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.kh.common.BmLogFactory;



/**
 * Servlet implementation class H_SessionServlet
 */
// @WebServlet("/H_SessionServlet")
public class H_SessionServlet extends HttpServlet {
	
	//private BmLogFactory Logger =  BmLogFactory.getInstance();
	Logger log = Logger.getLogger(H_SessionServlet.class);
	
	private static final long serialVersionUID = 1L;


	public H_SessionServlet() {
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
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		// 사용자가 보낸 uri가 / session/login 으로 끝날 경우
		if (command.equals("/session/logIn")) {
			// login메서드 호출
			logIn(request, response);

			// 사용자가 보낸 uri가 / session/logout 으로 끝날 경우
		} else if (command.equals("/session/logOut")) {
			// logout메서드 호출
			logOut(request, response);
		}
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

	int total = 0;
	
	private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 세션이 존재하지 않을 경우에 세션을 만들지 않음
		// HttpSession session = request.getSession(false);
		System.out.println("로그인");
		HttpSession session = request.getSession();

		if (getServletContext().getAttribute("total") != null) {
			if(session.getAttribute("id") == null) {
				total = (int) (getServletContext().getAttribute("total"));
				getServletContext().setAttribute("total", ++total);
			}
		} else {
			getServletContext().setAttribute("total", 1);
		}

		session.setAttribute("id", request.getParameter("id"));
		log.info(request.getParameter("id") + "님이 로그인 하셨습니다.");
		
		
		// 브라우저 Off후에도 session.getId()
		// response.setHeader("Set-Cookie", "JSESSIONID=" + session.getId() +
		// ";Max-Age=3600;Path=/servlet01");
		// session.setMaxInactiveInterval(5);

		System.out.println(session.getId());


		PrintWriter pw = response.getWriter();

		if (session.getAttribute("id") != null) {
			pw.write("<h1>" + session.getAttribute("id") + " 님 환영합니다!"
					+ "<a href='/servlet01/session/logOut'>로그아웃하기</a></h1>");
		}

		pw.println("<h2>현재 로그인 중이 회원은 " + (int) (getServletContext().getAttribute("total")) + "명 입니다.</h2>");

		pw.write("<h3> index </h3>");
		pw.write("<a href='/servlet01/index.html'>index.html</a><br>");
		pw.write("<a href='/servlet01/1_submit.html'>1_submit.html</a><br>");
		pw.write("<a href='/servlet01/2_request.html'>2_request.html</a><br>");
		pw.write("<a href='/servlet01/3_responseTest.html'>3_responseTest.html</a><br>");
		pw.write("<a href='/servlet01/4_pageChange.html'>4_pageChange.html</a><br>");
		pw.write("<a href='/servlet01/5_cache.html'>5_cache.html</a><br>");
		pw.write("<a href='/servlet01/6_cookie.html'>6_cookie.html</a><br>");
		pw.write("<a href='/servlet01/7_session.html'>7_session.html</a><br>");
		pw.write("<a href='/servlet01/toDayMenu.html'>toDayMenu.html</a><br>");

		pw.flush();
		pw.close();
	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		System.out.println("로그아웃");
		HttpSession session = request.getSession();

		
		// 세션 자체가 내려간다.
		// session.invalidate();
		
		//로그인이 된상태라면~
		if(session.getAttribute("id") != null) {
			total = (int) getServletContext().getAttribute("total");
			getServletContext().setAttribute("total", --total);
			//로그아웃 로직
			session.removeAttribute("id");
		}

		// int logoutRes = (session == null ? 0) :
		// (int)(session.getAttribute("logoutRes"));
		
		PrintWriter pw = response.getWriter();
		pw.println("<h2>현재 로그인 중이 회원은 " + total + "명 입니다.</h2>");

		pw.write("<h3> index </h3>");
		pw.write("<a href='/servlet01/index.html'>index.html</a><br>");
		pw.write("<a href='/servlet01/1_submit.html'>1_submit.html</a><br>");
		pw.write("<a href='/servlet01/2_request.html'>2_request.html</a><br>");
		pw.write("<a href='/servlet01/3_responseTest.html'>3_responseTest.html</a><br>");
		pw.write("<a href='/servlet01/4_pageChange.html'>4_pageChange.html</a><br>");
		pw.write("<a href='/servlet01/5_cache.html'>5_cache.html</a><br>");
		pw.write("<a href='/servlet01/6_cookie.html'>6_cookie.html</a><br>");
		pw.write("<a href='/servlet01/7_session.html'>7_session.html</a><br>");
		pw.write("<a href='/servlet01/toDayMenu.html'>toDayMenu.html</a><br>");

		pw.flush();
		pw.close();
		// response.sendRedirect("servlet01/7_session.html");
	}
}
