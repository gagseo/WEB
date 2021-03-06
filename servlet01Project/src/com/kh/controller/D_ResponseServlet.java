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
 * Servlet implementation class D_ResponseServlet
 */
// @WebServlet("/D_ResponseServlet")
public class D_ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public D_ResponseServlet() {
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

		
		// Content-Type : MIME type 지정
		//		MIME TYPE : 서버가 응답할 데이터의 유형을 나타내주기 위해 사용
		//		text : 문자 text/html  text/css  text/javascript
		//		image : 이미지  image/gif  image/png
		//		application : 바이트
		//		multipart : 복합, 브라우저가 어떻게 처리해야할지 몰라서 파일을 다운받음
		//		content-dispositon : inline으로 지정해도 multipart일 경우 파일을 다운로드 받음
		
		// Content-Disposition : 브라우저에게 컨텐츠가 inline 되어야 하는 컨텐츠인지
				// 아니면 파일로 받아야하는 컨텐츠인지 알려준다.
				// attachment : 파일형태, inline : 브라우저에 띄워준다.
		
		// 파일형태로 다운로드 됨
		// response.setHeader("content-Type", "multipart/byteranges");

		// 파일로 받아지는데 파일명을 지정할 수 있다
		// response.setHeader("content-Disposition","attachment; filename=uclass.txt" );
		
		response.setHeader("Content-Disposition", "inline");

		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			pw.write("<h1>" + session.getAttribute("id") + " 님 환영합니다!</h1>");
		}
		
		pw.println("<h3>HttpServeletResponse : 클라이언트에게 응답을 보내기 위한  기능들을 가지고 있는 객체</h3>");
		pw.println("<h3>setContentType() : 응답으로 작성하는 페이지의 MIME타입을 지정 </h3>");
		pw.println("<h3>setCharacterEncoding(String) : 응답할 데이터의 인코딩 지정</h3>");
		pw.println("<h3>getWriter() : printWriter</h3>");
		pw.println("<h3>getOutputStream : OutputStream</h3>");
		pw.println("<h3>sendRedirect(String) : 브라우저에게 매개변수로 보낸 주소로 다시 요청할 것을 요청</h3>");

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
