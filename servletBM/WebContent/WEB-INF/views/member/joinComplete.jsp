<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 가입 성공!</h1>
	<h3>--- 회원 정보 ---</h3>


	<%=request.getParameter("userId")%>
	<%=request.getParameter("userPwd")%>
	<%=request.getParameter("m_email")%>
	<%=request.getParameter("m_tell")%>



















</body>
</html>