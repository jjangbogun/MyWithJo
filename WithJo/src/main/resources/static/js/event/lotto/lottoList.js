function lottosearch() {
	var searchNField = $("#searchNField").val();
	var searchNKeyword = $("#searchNKeyword").val();
	
	$("#searchField").val(searchNField);
	$("#searchKeyword").val(searchNKeyword);
	$("#curPage").val(1);
	
	$("#pagingForm").submit();			
}

function pageMoveAdd() {
    location.href = './add';
}

function pageMoveDetail() {
    location.href = './detail';
}
/*
function movelotto() {		
    location.href = '/lotto/list';
}

function moveBoard() {		
    location.href = '/board/list';
}

function moveCustomer() {		
    location.href = '/customer/list';
}*/