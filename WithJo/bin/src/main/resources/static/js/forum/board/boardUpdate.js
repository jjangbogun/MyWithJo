function boardCheck() {
	let boardContent2 = $('#boardContent2').val();
	boardContent2 = boardContent2.replaceAll(/'/g, '`');
	boardContent2 = boardContent2.replaceAll(/"/g, '&quot;');
	$('#boardContent').val(boardContent2);		
	document.getElementById("boardForm").submit(); 
}

function imgDelete() {
	$('#boardImgDelete').val('1');
	boardCheck();
}