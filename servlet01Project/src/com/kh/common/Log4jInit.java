package com.kh.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

//@WebServlet("/Log4jInit")

// <load-on-startup>1</load-on-startup>
// load-on-startup : 할당된 값이 양수면 서버가 실행될 때 메모리에 서블릿을 올린다.
// load-on-startup이 설정된 서블릿이 많다면, 숫자가 적게 설정된 서블릿 부터 메모리에 올라간다.
public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Log4jInit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {

		super.init();
		// web폴더!!
		String prefix = getServletContext().getRealPath("/");
		String file = getInitParameter("logProp");
		// 절대경로 잡아주기 : web폴더까지 잡아주니 그이하 잡아줌
		PropertyConfigurator.configure(prefix + file);
		
	}

}
