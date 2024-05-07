<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function () {
    // 로컬 스토리지에서 제품 정보 가져오기
    var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
    //판매가격을 숫자로 변환 후 다시 쉼표와 원화 붙여주기
    var formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'KRW'
    });
    // 비어있으면 장바구니가 비어있다고 표시
    if (cartItems.length === 0) {
        $("main.container").append("<h1 class='cartnone'>Empty Cart</h1>");
    } else {
    	let totalPrice=0;
        // 장바구니에 제품 표시
        cartItems.forEach(function (item, index) {
            // 각 제품 정보를 화면에 추가하는 코드 (예: 테이블에 추가)
            $("main.container").append("<div class='component-container'><h3>&nbsp;&nbsp;" + item.company + 
                "</h3><span>&nbsp;&nbsp;" + item.name + "</span><br><img src='../save/" + item.photo + "'><h4>"+
                item.price+
                '<div style="text-align: right; margin-bottom: 15px;">' +
                '<button type="button" class="btnDeleteEach" data-index="'+index+'">장바구니 삭제</button>' +
                '</div></div>');
            var priceInt=item.price.replace(/[^\d]/g, "");
            totalPrice+=parseInt(priceInt.trim());
            
        });
        $("main.container").before("<h2 class='totalPrice'>총 금액:"+formatter.format(totalPrice)+"</h2>");
    }   
   
});
</script>
<body>
    <main class="container">        
    </main>
    <div class="cartButtons">
    <button type="button" id="btnDelCartAll">장바구니 전체 삭제</button>
    </div>
</body>
<jsp:include page="MainPage.jsp"></jsp:include>
</html>