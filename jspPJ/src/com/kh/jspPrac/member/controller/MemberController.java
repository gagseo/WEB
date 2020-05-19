package com.kh.jspPrac.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jspPrac.member.model.service.MemberService;
import com.kh.jspPrac.member.model.vo.Member;

/**
 * Servlet implementation class MemberJoinServlet
 */
// @WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService ms = new MemberService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
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

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		if (command.equals("/member/join")) {

			insertMember(request, response);

		} else if (command.equals("/member/idCheck")) {
			// 나중에 만들 메서드를 호출

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

	private void insertMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = null;
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String tell = request.getParameter("m_tell");

		Member m = new Member();

		m.setmId(id);
		m.setmPassword(pwd);
		m.setmTell(tell);
		
		ms.insertMember(m);
		
		request.setAttribute("member", m);
		
		view = request.getRequestDispatcher("/views/member/04_joinComplete.jsp");
		view.forward(request, response);

	}

}
