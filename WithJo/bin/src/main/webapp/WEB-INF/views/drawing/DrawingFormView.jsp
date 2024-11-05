<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<meta charset="UTF-8">
<title>게시글 추럼 등록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/event/drawing/DrawingAdd.css">
<script src="/js/event/drawing/drawingForm.js"></script>
</head>
<script type="text/javascript">
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

            console.log("선택된 회원 번호:", selectedMemberNos); // 콘솔에 로그 출력
            console.log("drawingMemberNo의 값:", $('#drawingMemberNo').val());
        },
        error: function(xhr, status, error) {
            alert('Error: ' + error);
        }
    });
}
</script>
<body>
	
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	<input type="hidden" id="drawingMemberNo" name="drawingMemberNo" value="">
	<input type="hidden" id="drawingMemberName" name="drawingMemberName" value="">
	<input type="hidden" id="drawingMemberId" name="drawingMemberId" value="">
	<input type="hidden" id="memberNo" name="memberNo" value="${memberVo.memberNo}">
	<div id="drawingAddContainer">
		<h1>게시글 추첨 등록</h1>
		    
		    <div>
		        <label for="drawingRound">게시글 추첨 회차</label><br>
		        <input type="number" id="drawingRound" name="drawingRound"><br>
		    </div>
		    
		    <div>
		        <label for="drawingStartDate">회차시작날짜</label><br>
		        <input class="dateInput" type="date" id="drawingStartDate" name="drawingStartDate"><br>
		    </div>
		    
		    <div>
		        <label for="drawingEndDate">회차종료날짜</label><br>
		        <input class="dateInput" type="date" id="drawingEndDate" name="drawingEndDate"><br>
		    </div>
		    
		    <div>
		        <label for="personnel">추첨 인원</label><br>
		        <input type="number" id="personnel" name="personnel"><br>
		    </div>
		    
		    <div id="drawingSelect">
		    
		    </div>
		    
		    <div id="btnDiv">
		        <input class="drawingBtn3" type="button" value="게시글 회원추첨" onclick="makeDrawingMember();">
		        <input class="drawingBtn3" type="button" value="등록" onclick="addDrawing();">
				<input class="drawingBtn3" type="button" value="뒤로가기" onclick="pageMoveList();">
		    </div>
	</div>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>