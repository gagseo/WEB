package com.kh.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.RC2ParameterSpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.filter.DataWrapper;

/**
 * Servlet implementation class J_FilterWrapper
 */
// @WebServlet("/J_FilterWrapper")
public class J_FilterWrapper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public J_FilterWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		
		
		
		//방금만든 getCommandMap() 메서드 호출해서
		//Map<String, Object> commandMap 에 넣기
		
		Map<String, Object> commandMap = (Map<String, Object>)new DataWrapper(request).getCommandMap();
		System.out.println(commandMap);
		
		
		
		//DataWrapper에서 오버라이딩 한 getRequestDispathcher() 메서드 호출
				//오버라이딩 된 getRequestDispathcher() 메서드는 매개변수로 받은 파일명을
				//WEB-INF/img/tomcat.png 로 재지정 해준다.
		RequestDispatcher rd = request.getRequestDispatcher("tomcat");
		rd.forward(request, response);
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
