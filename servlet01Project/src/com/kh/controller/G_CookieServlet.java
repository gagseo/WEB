package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class G_CookieServlet
 */
// @WebServlet("/G_CookieServlet")
public class G_CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public G_CookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession(false);

		// 쿠키의 지속시간
		// 쿠키의 지속시간을 지정하지 않으면 세션쿠기가 된다.
		// 세션 쿠기는 세션스코프를 지니는 쿠키를 이야기한다.
		// 세션스코프 : 사용자가 브라우저를 종료할 때 까지 쿠기가 존재

		String search = request.getParameter("search");
		String recentSearch = "최근 검색어가 없습니다.";

		// request.getCookies() Cookie배열을 반환
		if (request.getCookies() != null) {
			for (Cookie ck : request.getCookies()) {
				if (ck.getName().equals("recentSearch")) {
					recentSearch = ck.getValue();
				}
			}
		}

		// 헤더에 직접 담아주는 방법
		// response.setHeader("Set-Cookie", "recentSearch=" + search);

		// 컨테이너가 제공해주는
		// Cookie 생성
		// 위와 같은 코드
		Cookie cookie = new Cookie("recentSearch", search);
		cookie.setMaxAge(3600);
		// response header에 쿠기를 추가
		// 이후 request가 발생할때 마다 request header에 쿠키가 담겨 온다.
		response.addCookie(cookie);

		PrintWriter pw = response.getWriter();

		if (session != null) {
			pw.write("<h1>" + session.getAttribute("id") + " 님 환영합니다!</h1>");
		}

		pw.println("<h3>최근검색어 : " + recentSearch + "</h3>");
		pw.println("<h1>검색어 : " + request.getParameter("search") + "</h1>");

		pw.flush();
		pw.close();

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
