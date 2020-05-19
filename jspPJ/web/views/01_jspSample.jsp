<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 기초</h1>
	<p>
		JSP는 기존에 서버용 자바언어인 Servlet에서 <br> 화면 구현에 관련된 소스 부분을 별도로 분리하는 기술을
		말한다.
	</p>
	<hr>
	<h3>지시자 태그(Directive)</h3>
	<%
		String startDirective = "<%@   ";
	%>
	<%
		String endDirective = "% >";
	%>
	<pre><%=startDirective + endDirective%></pre>
	<p>
		지시자 태그란, 해당하는 페이지 전체에서 사용할 속성을<br> 지정할 때 사용하는 JSP 태그
	</p>
	<p>
		1. page : 해당 페이지 전체 속성을 지정하는 태그<br> 1-1 : import 필요한 자바의 클래스를
		import 할 때 사용합니다.<br> <br> 2. include : 다른 위치의 html/jsp 페이지를
		현재 페이지에 삽입하는 태그<br> 3. taglib : 사용자나 다른 라이브러리에서 제공하는 커스텀 태그를 정의할
		때 사용하는 속성
	</p>
	<hr>
	<h3>스키립틀릿 태그(Scriptlet)</h3>
	<%
		String startScriptlet = "<%   ";
		String endScriptlet = "% >";
	%>
	<pre><%=startScriptlet + endScriptlet%></pre>
	<p>
		해당 페이지 내부에서 자바 소스코드를 작성하는<br> 영역을 나타내는 JSP 태그, 스트립틀릿은 내부적으로 메서드
		안에서 수행된다.<br> 따라서 static 변수나 메서드 선언 등을 할 수 없다.
	</p>
	<hr>
	<h3>선언 태그(Declaration)</h3>
	<pre>
		<%
			declaration();
		%>
	</pre>
	<p>
		선언태그는 클래스의 필드에 해당한다.<br> 메서드 선언 가능, static변수 선언가능
	</p>
	<%!public String declaration() {

		String startDeclaration = "<%!   ";
		String endDeclaration = "% >";

		return startDeclaration + endDeclaration;

	}%>
	<hr>
	<h3>표현식 태그(Expression)</h3>
	<%
		String startExpression = "<%=   ";
		String endExpression = "% >";
	%>
	<!-- <%="안녕하세요"%> -> out.write("안녕하세요"); -->
	<!-- ; 마침표 찍지말것 -->
	<pre><%=startExpression + endExpression%></pre>
	<p>
		표현식 태그란, 특정 객체나, 변수의 값을 출력하는 <br> 용도로 사용하는 JSP태그이다.
	</p>

	<hr>

	<h3>주석 태그</h3>
	<pre>&lt;%-- --%&gt;</pre>
	<p>
		<!--  -->
		주석 태그는 해당 페이지에서 사용되는 JSP코드나 <br> 서버영역의 코드를 주석처리하기 위한 태그이다.
	</p>






















</body>
</html>