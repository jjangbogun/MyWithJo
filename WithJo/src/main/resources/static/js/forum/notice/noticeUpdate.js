function noticeCheck() {
	let noticeContent2 = $('#noticeContent2').val();
	noticeContent2 = noticeContent2.replaceAll(/'/g, '`');
	noticeContent2 = noticeContent2.replaceAll(/"/g, '&quot;');
	$('#noticeContent').val(noticeContent2);		
	document.getElementById("noticeForm").submit(); 
	alert("수정이 완료되었습니다.");
}

function imgDelete() {
	$('#noticeImgDelete').val('1');
	noticeCheck();
}