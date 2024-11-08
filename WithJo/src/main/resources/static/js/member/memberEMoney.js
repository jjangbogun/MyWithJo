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

	
	




