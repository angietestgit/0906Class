<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<style>
/* 웹폰트 */
@import
	url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR&display=swap')
	;

/* 기본 설정 */
* {
	margin: 0;
	padding: 0;
	font-family: 'Noto Sans KR', sans-serif;;
}

body {
	background-color: #EEE;
}

.font_gray {
	color: #666;
}

.margin_tb_5 {
	margin-top: 5px;
	margin-bottom: 5px;
}

.lineheight_180per {
	line-height: 180%; /*p태그 16px의 180%*/
}

/* 타이틀 폰트 */
.title_font {
	font-family: 'Jua', sans-serif;
}

/* main_wrap 설정*/
#main_wrap {
	background-color: white;
	width: 778px; /*보더2 주기위해 애매한 숫자798씀-20(패딩값)*/
	/* height: 300px; 확인용 height*/
	/* 패딩*/
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	margin: 10px auto; /*auto 가운데*/
	box-shadow: 3px 5px 10px #ccc;
}

/* header 설정*/
header {
	/*폭 주지말고(기본100)*/
	padding: 30px;
}

/* 네비게이션 설정*/
nav {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	overflow: hidden;
}

nav>ul {
	float: left;
	list-style: none;
}

nav>ul>li {
	float: left;
	padding: 5px 15px;
}

nav>div {
	float: right;
}

/* 검색 영역 */
nav input {
	border: 1px solid #aaa;
	padding: 3px 20px;
	margin-top: 3px;
}

nav input[type=text] {
	width: 100px;
	border-radius: 20px 0 0 20px;
}

nav input[type=button] {
	border-radius: 0 20px 20px 0;
	margin-left: -1px;
	margin-right: 5px;
}

/* Contents 영역 설정 */
#contents_wrap {
	overflow: hidden;
}

#contents_wrap>section { /*왼쪽*/
	width: 600px;
	float: left;
}

#contents_wrap>asice { /*오른쪽*/
	width: 170px;
	float: right;
}

#contents_wrap>section>article {
	padding: 25px;
	border-bottom: 1px solid #ccc;

	/*padding-bottom: 20px;
    margin-bottom: 20px; 다른 게시물과의 여백 굳이 할 필요없어서 생략*/
}

#contents_wrap>section>article>img {
	width: 500px; /*현재 최대를 600으로 잡아놔서 일단 500*/
}

/* aside 영역 설정 */
/* #contents_wrap>aside {
    padding-top: 20px;
} */
#contents_wrap>aside>h3 { /*위와 출력은 같음 이렇게 한 이유는 사이드메뉴 두개하려고*/
	margin-top: 30px;
}

#contents_wrap>aside>ul>li {
	/* #contents_wrap>aside li { 위와 차이 구분하기*/
	list-style: none;
	padding-left: 10px;
}

/* footer 설정 */
footer {
	height: 30px;
	text-align: left;
	line-height: none;
}
</style>
</head>

<body>
	<div id=main_wrap>
		<!-- header -->
		<%@ include file="blogJsp/header.jsp" %>
		<!-- navigation -->
		<%@ include file="blogJsp/nav.jsp" %>
	
				<!-- contents -->
		<div id="contents_wrap">
			<%@ include file="blogJsp/section.jsp" %>
			<%@ include file="blogJsp/aside.jsp" %>
		</div>
		<!-- footer -->
		<%@ include file="blogJsp/footer.jsp" %>
	
	</div>
	

</body>
</html>