<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 기본 사용</h1>

	<%
		int total = 0;
		for (int i = 1; i < 11; i++) {
			total += i;
	%>

	<h5><%=total%></h5>

	<%
		}
	%>

	<h3>
		1부터 10까지의 합은
		<%=total%></h3>


	<%
		int sum = 0;
		String res = "";
		for (int i = 0; i < 11; i++) {
			sum += i;
			res += "+" + i;
	%>

	<h3><%=res%>=<%=sum%></h3>

	<%
		}
	%>



</body>
</html>