const mysidebar = document.querySelector("nav.sidebar");
const toggleBtn = document.querySelector(".toggle-btn");
const mainmenu = document.querySelector(".list-item");
const submenu = document.querySelector(".submenu");

$(".submenu").hide();
toggleBtn.addEventListener("click", function () {
  mysidebar.classList.toggle("active");
  $(".submenu").slideUp();
});

function sendOrderByValueToServer() {
    let selectedValue = $("select[name='orderBy']").val();

    // AJAX를 사용하여 선택된 값을 서버로 전송합니다.
    $.post("Framelist.jsp", { orderBy: selectedValue }, function(data) {
        // 서버로부터 받은 새로운 데이터를 사용하여 게시판의 내용을 업데이트합니다.
        $("#boardContent").html(data);
    });
    };
    
$(document).ready(function () {
  $("nav.sidebar>ul.list>li.list-item>a").click(function (e) {
    e.preventDefault();
    let p = $("nav.sidebar").css("--p");
    if (parseInt(p) === 5) {
      $(this).siblings("ul.submenu").slideToggle();
      $(this).parent().siblings().find("ul.submenu").slideUp();
    }
    
  });
   
   
  $("select[name='orderBy']").on("change", function() {
        sendOrderByValueToServer();
    });
    sendOrderByValueToServer();
    
   $("#dashboard").click(function(){
	location.href="Homepage.jsp";
   });
   
   $("#cart").click(function(){
	location.href="cart.jsp";
   });
   
  });

// 장바구니 추가 버튼 클릭 이벤트 핸들러
$(".btnApply").on("click", function () {
    // 클릭된 제품 정보 가져오기
    var productInfo = {
        company: $(this).closest(".component-container").find("h3:first").text().trim(),
        name: $(this).closest(".component-container").find("h3:eq(1)").text().trim(),
        price: $(this).closest(".component-container").find("h4").text().trim(),
        photo: $(this).closest(".component-container").find("img").attr("src").trim()
        
    };

    // 로컬 스토리지에 제품 정보 저장
    var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
    cartItems.push(productInfo);
    localStorage.setItem("cartItems", JSON.stringify(cartItems));
    alert("상품이 추가되었습니다");
});

$("#btnDelCartAll").on("click",function(){
	let confirmAllDel=confirm("장바구니 전체를 삭제하시겠습니까?");
	if(confirmAllDel){
		localStorage.removeItem("cartItems");
		location.reload();
	}
});

 $("main.container").on("click","button.btnDeleteEach",function(){
    	let confirmEachDel=confirm("해당 제품을 장바구니에서 삭제하시겠습니까?");
    	var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
    	var index = $(this).data("index");
    	if(confirmEachDel){
        // 해당 인덱스의 상품 정보를 로컬 스토리지에서 삭제
        cartItems.splice(index, 1);
        localStorage.setItem("cartItems", JSON.stringify(cartItems));
        // 페이지 다시 로드
        location.reload();
        }
    });
