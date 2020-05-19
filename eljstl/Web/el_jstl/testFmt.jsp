<%@page import="java.util.Date"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fmt:formatDate 사용법</h1>
	<hr>
	<h3>fmt:formatDate 태그 : 날짜와 시간에 포맷 적용하는 태그</h3>
	value 속성에는 java.util.Date 객체를 사용해야 함
	<fmt:formatDate value="<%=new Date()%>" />
	<c:set var="current" value="<%=new Date()%>" />
	<ul>
		<li>오늘 날짜 : <fmt:formatDate value="${current }" /></li>
		<li>현재 시간 : <fmt:formatDate value="${current }" type="time" /></li>
		<li>둘 다 : <fmt:formatDate value="${current }" type="both" /></li>
		<li>[full, short] : <fmt:formatDate value="${current }"
				type="both" dateStyle="full" timeStyle="short" /></li>
		<li>[Long,medium] : <fmt:formatDate value="${current }"
				type="both" dateStyle="long" timeStyle="medium" /></li>
		<li>내 패턴 : <fmt:formatDate value="${current }" type="both"
				pattern="yy-MM-dd(E) HH:mm:ss(a)" /></li>
		<li>타임존 : <fmt:formatDate value="${current }" type="both"
				pattern="yy-MM-dd(E) HH:mm:ss(a)" timeZone="Oakland" /></li>
	</ul>

	<h3>
		fmt:setLocals : 지역대 설정하는 태그<br> fmt:timeZone : 시간대 설정하는 태그
	</h3>
	<fmt:timeZone value="Pacific/Auckland">
	오클랜드 현재 시간 : <fmt:formatDate value="${current }" type="both" />
	</fmt:timeZone>
	<hr>
	<h3>fmt:formatNumber : 숫자데이터 포맷 지정태그</h3>
	일반 숫자 : 123456
	<br> 천단위 구분 :
	<fmt:formatNumber value="123456" groupingUsed="true" />
	<br> 금액 :
	<fmt:setLocale value="en_us" />
	<fmt:formatNumber value="1000000" type="currency" /><br>
	금액 :
	<fmt:setLocale value="ja-jp" />
	<fmt:formatNumber value="1000000" type="currency" /><br>
		금액 :
	<fmt:setLocale value="ko-kr" />
	<fmt:formatNumber value="1000000" type="currency" /><br>

























</body>
</html>