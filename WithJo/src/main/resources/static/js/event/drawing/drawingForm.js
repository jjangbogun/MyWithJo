
function pageMoveList() {
    location.href = '/drawing/list';
}



function addDrawing() {
    var drawingRound = $('#drawingRound').val().trim();
	var drawingPersonnel = $('#personnel').val().trim();
    var drawingStartDate = $('#drawingStartDate').val().trim();
    var drawingEndDate = $('#drawingEndDate').val().trim();
    var drawingMemberNo = $('#drawingMemberNo').val().trim();
    var drawingMemberName = $('#drawingMemberName').val().trim();
    var drawingMemberId = $('#drawingMemberId').val().trim();

    if (!drawingRound || !drawingStartDate || !drawingEndDate || !drawingMemberName || !drawingMemberNo) {
        alert("모든 필드를 입력해주세요.");
        return;
    }

    var memberNo = parseInt($('#memberNo').val(), 10);

    var drawingData = {
        memberNo: memberNo,
		drawingPersonnel: drawingPersonnel,
        drawingStartDate: drawingStartDate,
        drawingEndDate: drawingEndDate, 
        drawingRound: parseInt(drawingRound, 10),
        drawingMemberNo: drawingMemberNo,
		drawingMemberName: drawingMemberName,
		drawingMemberId: drawingMemberId
    };

    $.ajax({
        url: '/drawing/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(drawingData),
        success: function (data) {
            alert("등록이 완료되었습니다");
            window.location.href = "/drawing/list";
        },
        error: function(xhr, status, error) {
            alert('Error: ' + status + ' - ' + error);
        }
    });
}
