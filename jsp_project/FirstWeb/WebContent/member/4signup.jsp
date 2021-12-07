<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String uid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	String pwCheck = request.getParameter("pwCheck");
	String username = request.getParameter("username");
	String comment = request.getParameter("comment");
	String gender = request.getParameter("gender");
	String[] interests = request.getParameterValues("interest");

	String byear = request.getParameter("byear");

	%>
	
	<h1>
		User ID: <%=uid %> <br>
		Password: <%=pw %> <br>
		Name: <%=username %> <br>
		comment : <%=comment %><br>
		gender : <%= gender %><br>
		<% 
		if(interests != null) {
			for(int i=0; i<interests.length; i++) {
				out.println("interest : " + interests[i] +  "<br>");
			}
		} else {
			out.println("interest : 선택된 관심사가 없습니다.<br>");
		}
		%>
		
		byear : <%= byear %><br>
		
	</h1>
	
</body>
</html>