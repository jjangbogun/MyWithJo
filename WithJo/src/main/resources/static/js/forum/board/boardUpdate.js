function boardCheck() {
	let boardContent2 = $('#boardContent2').val();
	console.log(boardContent2);
	boardContent2 = boardContent2.replaceAll(/'/g, '`');
	boardContent2 = boardContent2.replaceAll(/"/g, '&quot;');
	$('#boardContent').val(boardContent2);		
	document.getElementById("boardForm").submit(); 
	alert("수정이 완료되었습니다.");
}

function imgDelete() {
	$('#boardImgDelete').val('1');
	boardCheck();
}

