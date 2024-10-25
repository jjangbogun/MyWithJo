function customersearch() {
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

function moveNotice() {		
    location.href = '/notice/list';
}

function moveBoard() {		
    location.href = '/board/list';
}

function moveCustomer() {		
    location.href = '/customer/list';
}