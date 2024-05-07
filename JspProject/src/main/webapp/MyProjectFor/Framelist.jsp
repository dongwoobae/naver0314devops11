<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dto.FrameDto"%>
<%@page import="data.dao.FrameDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
String sql="select * from cycleproject.frame order by num";

String orderBy = request.getParameter("orderBy"); // request로부터 orderBy 파라미터 값을 받아옴
if (orderBy != null) {
    // orderBy 파라미터가 존재하면 쿼리를 변경
    if (orderBy.equals("latest")) {
        sql = "select * from cycleproject.frame order by num desc"; // 최신 순으로 변경
    } else if (orderBy.equals("highPrice")) {
        sql = "select * from cycleproject.frame order by price desc"; // 가격 높은 순으로 변경
    } else if (orderBy.equals("lowPrice")) {
        sql = "select * from cycleproject.frame order by price asc"; // 가격 낮은 순으로 변경
    }
}

FrameDao dao = new FrameDao();
List<FrameDto> list = dao.getAllFrames(sql);
DecimalFormat df = new DecimalFormat("###,###,###");

int totalItems = list.size();
int itemsPerPage=6;
int currentPage=(request.getParameter("page")!=null)?Integer.parseInt(request.getParameter("page")) : 1;
int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
int startIndex = (currentPage - 1) * itemsPerPage; // 페이지의 시작 인덱스
int endIndex = Math.min(startIndex + itemsPerPage, totalItems); // 페이지의 마지막 인덱스 (최대값: 전체 아이템 수)
List <FrameDto> currentPageItems = list.subList(startIndex, endIndex); // 현재 페이지에 해당하는 아이템들
String pageLink = "Framelist.jsp?orderBy=" + orderBy + "&page=";
%>
<body>
	<div class="mainselect-form">
		<form action="Framelist.jsp" method="post" class="formSel">
			<%
		String selectedValue = "register"; // 기본값 설정
		if (orderBy != null) {
		    selectedValue = orderBy;
		}
		%>
			<select name="orderBy">
				<option value="register"
					<%=selectedValue.equals("register")?"selected":""%>>등록 순</option>
				<option value="latest"
					<%=selectedValue.equals("latest")?"selected":""%>>최신 순</option>
				<option value="highPrice"
					<%=selectedValue.equals("highPrice")?"selected":""%>>가격 높은
					순</option>
				<option value="lowPrice"
					<%=selectedValue.equals("lowPrice")?"selected":""%>>가격 낮은
					순</option>
			</select>
			<button type="submit" class="btnApply-sm">go</button>
		</form>
	</div>
	<main class="container">
		<%
    for (FrameDto dto : currentPageItems) {
    %>
		<div class="component-container">
		<br>
			<h3>
				&nbsp;&nbsp;&nbsp;<%= dto.getCompany() %></h3>
			<span>
				&nbsp;&nbsp;&nbsp;<%= dto.getName() %></span><br>
			<img src="../save/<%= dto.getPhoto() %>">
			<h4>
				&nbsp;&nbsp;&#8361;<%= df.format(Integer.parseInt(dto.getPrice())) %></h4>
			<div style="text-align: right; margin-bottom: 15px;">
				<button type="button" class="btnApply">
					<img src="../image/cartImage.png">
				</button>
			</div>
		</div>
		<%
    }
    %>
	</main>
	<div class="pagination">
		<% if(currentPage > 1) { %>
		<a href="<%=pageLink + (currentPage - 1)%>"><<</a>
		<% } %>

		<% for(int i = 1; i <= totalPages; i++) { %>
		<a href="<%=pageLink + i%>"
			<%= (i == currentPage) ? "class='active'" : "" %>><%= i %></a>
		<% } %>

		<% if(currentPage < totalPages) { %>
		<a href="<%=pageLink + (currentPage + 1)%>">>></a>
		<% } %>
	</div>
</body>
<jsp:include page="MainPage.jsp"></jsp:include>
</html>