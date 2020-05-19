package com.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.model.vo.Score;

//@WebServlet("/ELController")
public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Score> sList = new ArrayList<Score>();

	public ELController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
	
		Score sc = new Score(name, kor, eng, math);

		boolean flg = true;
		for (Score s : sList) {
			if (s.equals(sc)) {
				flg = false;
			}
		}

		if (flg) {
			sList.add(sc);
		}

		request.setAttribute("sList", sList);

		RequestDispatcher rd = request.getRequestDispatcher("el_jstl/jstlPage.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	Score score = new Score();

}
