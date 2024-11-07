
$(document).ready(function() {
	$(".myPageCategoryBtn").on("click", function(){
		var buttonText = $(this).text();
		if(buttonText === "내 수강 목록"){
			window.location.href = "/member/test?memberNo=" + memberNo;	
		}
		if(buttonText === " 포인트 내역"){
			
		}
		if(buttonText === "회원정보변경"){
			window.location.href = "/member/update?memberNo=" + memberNo;	
		}				
		if(buttonText === "장바구니"){
			window.location.href = "/member/test?memberNo=" + memberNo;	
		}
	})
})