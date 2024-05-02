<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--��Ʈ��Ʈ��-->
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--�۲�-->
<link
	href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: "Gowun Batang";
	margin: 0px;
}

main {
	margin-left: 20px;
	margin-right: 20px;
}

h1 {
	text-align: center;
}

.navbar {
	display:flex;
	justify-content:center;
	
}
ul li{
list-style:none;
width:200px;
margin-left:30px;
}
li.mainMenu{
float:left;
align-content:center;

}
.navbar ul {
	list-style-type: none;
	background-color: darkgray;
	padding: 0px;
	margin: 0px;
	overflow: hidden;
}

.navbar a {
	display:block;
	color: white;
	text-decoration: none;
	padding: 15px;	
	text-align: center;
}

.navbar a:hover {
	color:black;
	
}
ul.submenu{
display:none;
}
header{
float:left;
position:fixed;
top:0px;
left:0px;
right:0px;

}
</style>
</head>
<script>
$(function(){
	$("li.mainMenu>a").hover(function(){
		//형제노드인 ul을 나타낸다
        $(this).siblings("ul.submenu").fadeIn("fast");
        //다른 서브 메뉴는 사라지게 하려면
        $(this).parent().siblings("li").find("ul.submenu").fadeOut("fast");
	})
})

</script>
<body>
<header>
	<h1>자전거 탄 풍경</h1>
	<br>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<ul>
			<li class="mainMenu"><a href="MainPage.jsp">Home</a></li>
			<li class="mainMenu"><a href="">About</a>
			<ul class="submenu">
			<li>페이지 기획 이유</li>
			<li></li>
			</ul>
			</li>
			<li class="mainMenu"><a href="">Products</a>
			<ul class="submenu">
			<li>로드 자전거</li>
			<li>MTB</li>
			<li>Gravel</li>
			</ul>
			</li>
			<li class="mainMenu"><a href="">Sight on Bike</a>
			<ul class="submenu">
			<li>서울 서부</li>
			<li>서울 동부</li>
			<li>그 외 지방</li>
			<li>제주도</li>
			</ul>
			</li>
			<li class="mainMenu"><a href="">Meet Friends</a>
			<ul class="submenu">
			<li>자전거 동호회</li>
			<li>지역 소모임</li>
			</ul>
			</li>
		</ul>
	</nav>
	</header>
	<main>
		<h3>This is the Homepage</h3>
		<p></p>
	</main>
</body>
</html>