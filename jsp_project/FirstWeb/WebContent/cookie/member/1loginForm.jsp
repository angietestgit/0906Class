<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--= request.getContextPath() --%>
	<!-- http://localhost:8080/FirstWeb(또는  first)/cookie/member/2login.jsp -->
	
	<form action="<%= request.getContextPath() %> /first/cookie/member/2login.jsp">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
		</table>
	</form>
	
</body>
</html>