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
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 400;
	font-style: normal;
}

body * {
	font-family: "Pretendard-Regular";
}
</style>
</head>
<body>
	<form action="./loginaction.jsp" method="post">
		<h5>기사를 보려면 먼저 암호를 입력하세요</h5>
		<b>암호 : </b><input type="password" name="amho">
		<button type="submit" style="margin-left: 10px">확인</button>
	</form>
</body>
</html>