<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 쿠키를 구워서 클라이언트에 저장하는 방법 실습 -->
<%
	// 쿠키 저장
	// 1. 쿠키 객체 생성 -> 2. reponse.addCookie()
	
	Cookie cookie1 = new Cookie("eName", "SON");
	cookie1.setMaxAge(10); //60*60*24*365
	
	Cookie c = new Cookie("kName", "손흥민");
	
	response.addCookie(cookie1);
	response.addCookie(c);
	
	response.addCookie(CookieBox.createCookie("uid", "cool"));
	response.addCookie(CookieBox.createCookie("chk", "0", 20));
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키가 저장되었습니다.</h1>
	<h3> <a href= ></a></h3>
</body>
</html>