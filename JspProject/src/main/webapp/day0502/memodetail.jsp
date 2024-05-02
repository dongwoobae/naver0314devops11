<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.MemoDao"%>
<%@page import="data.dao.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<!--��Ʈ��Ʈ��-->
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--�۲�-->
<link
	href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" />
<style>
body * {
	font-family: "Gowun Batang";
}
</style>
</head>
<% int num=Integer.parseInt(request.getParameter("num")); 
MemoDao dao=new
  MemoDao(); 
MemoDto dto=dao.getData(num); 
SimpleDateFormat sdf = new
  SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
<body>
	<h3>
	<b><%=dto.getTitle() %></b></h3>
	<h6 style="color:gray"><%=sdf.format(dto.getWriteday()) %></h6>
		<img src="../save/<%=dto.getUploadPhoto()%>" style="max-width: 400px"
			border="1" /> <br />
		<br />
		<pre style="font-size: 20px"><%=dto.getContent()%></pre>
		<hr />
		<button type="button" class="btn btn-info" onclick="history.back()">
			이전으로</button>
	
</body>
</html>
