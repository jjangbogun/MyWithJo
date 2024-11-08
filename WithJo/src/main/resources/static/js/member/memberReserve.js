function myPageCategoryBtnFnc(memberNo, categoryNo){
	
	if(categoryNo == 1){
		location.href = "/member/reserve?memberNo=" + memberNo;	
	}else if(categoryNo == 2){
		location.href = "/member/eMoney?memberNo=" + memberNo;
	}else if(categoryNo == 3){
		location.href = "/member/update?memberNo=" + memberNo;	
	}else if(categoryNo == 4){
		location.href = "/member/test?memberNo=" + memberNo;	
	}
}

function cancelCourse(memberCourseReserveNo){
	if(confirm("정말로 취소하시겠습니까?")){
		$.ajax({
			url: '/member/reserve/cancel',
			type: 'POST',
			data: { memberCourseReserveNo: memberCourseReserveNo },
			success: function(result){
				if(result === 'success'){
					alert("취소되었습니다");
					location.reload();
				}else{
					alert("취소가 실패되었습니다")
				}
			},
			error: function(){
				alert("오류가 발생했습니다")
			}
		});
	}
	
}