function drawingsearch() {
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

function deleteFnc(drawingNo) {        
    if(confirm("해당 회차를 삭제 하시겠습니까?")) {	    	
        $.ajax({
        	url: '/drawing/delete',
        	type: 'POST',
        	data: { drawingNo: drawingNo },
        	success: function(result) {
				alert("삭제되었습니다");
				location.reload();
			}
        });        
	}
}
