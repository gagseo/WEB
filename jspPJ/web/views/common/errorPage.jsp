<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- response.getStatus() -->
	<h1>에러가 발생했군요!</h1>
	<br>

	<%
		int status = response.getStatus();
		String msg = "";

		if (status == 404) {
			msg = "404번 에러입니다. form의 action, web.xml의 url-mapping, servlet forward() 파일 이름을 확인하세요.";
		} else if (status == 500) {
			msg = "500번 에러입니다. 콘솔창을 확인하세요.";
		}
	%>

	<h3>
		status code가
		<%=status%><br>
		<%=msg%>
	</h3>
	<%-- <%
		if (exception != null) {
	%>
	<%=exception.getMessage()%>
	<%
		}
	%> --%>
	<br>
	
	
	<img src="/jspPJ/resources/img/airmax95.png">
</body>
</html>