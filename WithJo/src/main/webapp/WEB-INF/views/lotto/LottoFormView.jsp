<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<meta charset="UTF-8">
<title>로또 등록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/event/lotto/LottoAdd.css">
<script src="/js/event/lotto/lottoForm.js"></script>
</head>
<script type="text/javascript">
function makeLottoNo() {
    $.ajax({
        url: '/lotto/make',
        method: 'POST',
        success: function (data) {
            let htmlStr = '<div id="lottoSelNo">' + data + '</div>';
            $('#lottoSelect').html(htmlStr);
        },
        error: function(xhr, status, error) {
            alert('Error: ' + status + ' - ' + error);
        }
    });
}

function addLotto() {
    var memberNo = parseInt($('#memberNo').val(), 10);
    var lottoMode = parseInt($('#authority').val(), 10); 
    var lottoRound = parseInt($('#lottoRound').val(), 10);
    var lottoStartDate = $('#lottoStartDate').val();
    var lottoEndDate = $('#lottoEndDate').val();
    var lottoSelNo = $('#lottoSelNo').text(); 

    var lottoData = {
        memberNo: memberNo,
        lottoMode: lottoMode, 
        lottoRound: lottoRound,
        lottoStartDate: lottoStartDate,
        lottoEndDate: lottoEndDate,
        lottoSelNo: lottoSelNo
    };

    $.ajax({
        url: '/lotto/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(lottoData),
        success: function (data) {
            alert("등록이 완료되었습니다");
            window.location.href = "/lotto/list";
        },
        error: function(xhr, status, error) {
            alert('Error: ' + status + ' - ' + error);
        }
    });
}
</script>

<body>
	
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="lottoAddContainer">
		<h1>로또 등록</h1>
		
		<input type="hidden" id="memberNo" name="memberNo" value="${memberVo.memberNo}">
		<input type="hidden" id="authority" name="authority" value="${memberVo.authority}">
		    
		    <div>
		        <label for="lottoRound">로또회차</label><br>
		        <input type="number" id="lottoRound" name="lottoRound"><br>
		    </div>
		    
		    <div>
		        <label for="lottoStartDate">회차시작날짜</label><br>
		        <input type="text" id="lottoStartDate" name="lottoStartDate"><br>
		    </div>
		    
		    <div>
		        <label for="lottoStartDate">회차종료날짜</label><br>
		        <input type="text" id="lottoEndDate" name="lottoEndDate"><br>
		    </div>
		    
		    <div id="lottoSelect">
		    
		    </div>
		    
		    <div id="btnDiv">
		        <input class="lottoBtn3" type="button" value="번호 뽑기" onclick="makeLottoNo();">
		        <input class="lottoBtn3" type="button" value="로또 등록" onclick="addLotto();">
				<input class="lottoBtn3" type="button" value="뒤로가기" onclick="pageMoveList();">
		    </div>
	</div>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>