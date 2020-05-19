<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- top.jsp로  --%>
<%-- <!-- 페이지 인포트 -->
<%@ page import="com.kh.jspPrac.member.model.vo.Member"%>
<%
	Member m = (Member) request.getAttribute("member");
%>	 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 매개변수 공유 -->
	<%@ include file="../include/top.jsp"%>

	<!-- 
	jsp action tag include는 include 지시자와 같은 기능을 한다.
	단, include 지시자는 inline 방식인 반면에
	jsp action tag의 include는 내부적으로 include되는 jsp를 호출하는 방식이다.
	 -->

	<!-- jsp action tag include -->

	<!-- 매개변수 공유 불가 -->
	<%-- <jsp:include page="../include/top.jsp" /> --%>

	<h1>회원 가입 성공!</h1>
	<h3>--- 회원 정보 ---</h3>
	<p>
		ID :<%=m.getmId()%><br> 비밀번호 :<%=m.getmPassword()%><br> 전화번호
		:<%=m.getmTell()%><br>
	</p>

	<h1>jsp usebean 액션태그1</h1>
	<h3>id, class, scope 중 하나라도 다르면 새로운 객체가 생성이 된다.</h3>
	<h3>----회원 정보----</h3>
	<jsp:useBean class="com.kh.jspPrac.member.model.vo.Member"
		id="pageMember" scope="page">
		<jsp:setProperty property="mId" value="user1" name="pageMember" />
		<jsp:setProperty property="mPassword" value="pass1" name="pageMember" />
		<jsp:setProperty property="mTell" value="010-2000-0000"
			name="pageMember" />
	</jsp:useBean>

	<p>
		ID :
		<jsp:getProperty property="mId" name="pageMember" /><br> PWD :
		<jsp:getProperty property="mPassword" name="pageMember" /><br>
		Tell :
		<jsp:getProperty property="mTell" name="pageMember" /><br>
	</p>
	<hr>

	<h3>jsp usebean 액션태그2</h3>
	<h3>id와 class, scope 가 모두 같은 객체가 존재하면 그 객체가 useBean에 담긴다.</h3>
	<h3>----회원 정보----</h3>
	<jsp:useBean id="member" class="com.kh.jspPrac.member.model.vo.Member"
		scope="request">
	</jsp:useBean>
	<p>
		ID :
		<jsp:getProperty property="mId" name="member" /><br> PWD :
		<jsp:getProperty property="mPassword" name="member" /><br> Tell :
		<jsp:getProperty property="mTell" name="member" /><br>
	</p>
	<hr>
	
	<%-- <jsp:forward page="../01_jspSample.jsp"/> --%>



















</body>
</html>