function boardCheck() {
	let boardContent2 = $('#boardContent2').val();
	boardContent2 = boardContent2.replaceAll(/'/g, '`');
	boardContent2 = boardContent2.replaceAll(/"/g, '&quot;');
	$('#boardContent').val(boardContent2);		
	document.getElementById("boardForm").submit(); 
	alert("게시글이 등록되었습니다."); 
}

function pageMoveList() {
    location.href = '/board/list';
}
