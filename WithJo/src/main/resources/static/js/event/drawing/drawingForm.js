function pageMoveList() {
    location.href = '/drawing/list';
}

function makeDrawingMember() {
    var boardStartDate = $('#drawingStartDate').val();
    var boardEndDate = $('#drawingEndDate').val();
    var personnel = $('#personnel').val();

    if (!boardStartDate || !boardEndDate || !personnel) {
        alert("기간과 인원을 설정해주세요");
        return;
    }

    $.ajax({
        url: '/drawing/make',
        method: 'POST',
        data: {
            "boardStartDate": boardStartDate,
            "boardEndDate": boardEndDate,
            "personnel": personnel
        },
        success: function (response) {
            let htmlStr = '<div id="drawingMemberNo">';
            let selectedMemberNos = []; // 선택된 회원 번호를 저장할 배열            
            let selectedMemberNames = []; // 선택된 회원 번호를 저장할 배열            
            let selectedMemberIds = []; // 선택된 회원 번호를 저장할 배열            

            response.selectedMembers.forEach(function(member) {
                htmlStr += '<p>번호: ' + member.MEMBER_NO + ', 이름: ' + member.MEMBER_NAME + ', 이름: ' + member.MEMBER_ID + '</p>';
                selectedMemberNos.push(member.MEMBER_NO); // 회원 번호를 배열에 추가
                selectedMemberNames.push(member.MEMBER_NAME); // 회원 번호를 배열에 추가
                selectedMemberIds.push(member.MEMBER_ID); // 회원 번호를 배열에 추가
            });

            htmlStr += '</div>';
            $('#drawingSelect').html(htmlStr);

            // 선택된 회원 번호 배열을 hidden input의 value로 설정
            $('#drawingMemberNo').val(JSON.stringify(selectedMemberNos));
            $('#drawingMemberName').val(JSON.stringify(selectedMemberNames));
            $('#drawingMemberId').val(JSON.stringify(selectedMemberIds));
        },
        error: function(xhr, status, error) {
            alert('Error: ' + error);
        }
    });
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
            // 선택된 회원 번호 배열을 추출해서 이머니 처리 호출
            var selectedMemberNos = JSON.parse($('#drawingMemberNo').val()); // 선택된 회원 번호 배열
            console.log(selectedMemberNos); 
            insertMemberEMoney(selectedMemberNos); // 이머니 처리 Ajax 호출

            alert("등록이 완료되었습니다");
            window.location.href = "/drawing/list"; // 등록 완료 후 리스트로 이동
        },
        error: function(xhr, status, error) {
            alert('등록 실패: ' + status + ' - ' + error);
        }
    });
}

function insertMemberEMoney(memberNos) {
    var emoneyData = {
        memberNos: memberNos, // 배열을 JSON 문자열로 변환
		eMoney: parseInt($('#eMoneyVal').val(), 10),
		round: parseInt($('#drawingRound').val(), 10)
    };

    $.ajax({
        url: '/drawing/emoney',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(emoneyData),
        success: function (data) {
            console.log('이머니 처리 성공:', data);
            // 필요시 처리 후 추가 작업 (예: 알림)
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('이머니 처리 실패: ' + status + ' - ' + error);
        }
    });
}
