function noticeCheck() {
	let noticeContent2 = $('#noticeContent2').val();
	noticeContent2 = noticeContent2.replaceAll(/'/g, '`');
	noticeContent2 = noticeContent2.replaceAll(/"/g, '&quot;');
	$('#noticeContent').val(noticeContent2);		
	document.getElementById("noticeForm").submit(); 
	alert("공지가 등록되었습니다.");
}

function pageMoveList() {
    location.href = '/notice/list';
}