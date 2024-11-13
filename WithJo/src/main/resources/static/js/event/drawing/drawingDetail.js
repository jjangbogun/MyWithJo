function divInMember() {
	var drawingMembers = $("#drawingMembers").val();
	var drawingMemberIds = $("#drawingMemberIds").val();

	var namesArray = JSON.parse(drawingMembers);
	var idsArray = JSON.parse(drawingMemberIds);
	
	var htmlStr = "";
	
	for (var i = 0; i < namesArray.length; i++) {
		htmlStr += '<p class="drawingMemberP">' + namesArray[i] + '&nbsp;&nbsp;(' + idsArray[i] + ')' + '</p>';
	}
	
	$("#divMemberContainer").html(htmlStr);		
}

function pageMovedrawingList() {
	location.href = '/drawing/list?curPage=' + prevPage;
}

function pageMoveEventList() {
	location.href = '/event/list';
}