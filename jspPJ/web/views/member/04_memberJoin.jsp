<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
에러페이지 테스트를 위한 에러코드
<% 
String str = null;
	str.charAt(1);
%> 
--%>
	<h1>직원 가입 양식</h1>
	<form action="<%=request.getContextPath()%>/member/join">
	<%= request.getContextPath() %>
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="userId" size="10"></td>
			</tr>
			<tr>
				<td>PassWord :</td>
				<td><input type="Password" name="userPwd" size="10"></td>
			</tr>
			<tr>
				<td>휴대폰번호 :</td>
				<td><input type="text" name="m_tell" size="13"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="가입">
					<input type="reset" value="취소"></td>
			</tr>
		</table>

	</form>
</body>
</html>