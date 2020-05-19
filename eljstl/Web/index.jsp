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

	<a href="el_jstl/testCore.jsp?no=123">testCore페이지 이동1</a>
	<c:url var="tc" value="el_jstl/testCore.jsp">
		<c:param name="no" value="54321"></c:param>
	</c:url>
	<br>

	<a href="${tc }">testCore페이지 이동2</a>











</body>
</html>