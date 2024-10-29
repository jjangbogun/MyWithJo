<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>로또하기</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/event/lotto/lottoDetail.css">
<script src="/js/event/lotto/lottoDetail.js"></script>
<style>

</style>
<script>
    const lottoSelNoStr = "${lottoVo.lottoSelNo}";
    const lottoSelNoArray = JSON.parse(lottoSelNoStr);

    function getRandomColor() {
        const letters = '0123456789ABCDEF';
        let color = '#';
        for (let i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }

    window.onload = function() {
        const winningLottoSelNoDiv = document.getElementById("winningLottoSelNo");
        winningLottoSelNoDiv.innerHTML = ""; // 기존 내용 제거

        lottoSelNoArray.forEach(num => {
            const numDiv = document.createElement("div");
            numDiv.className = "lottoNumber"; // 클래스 추가
            numDiv.textContent = num; // 숫자를 div에 추가
            numDiv.style.backgroundColor = getRandomColor(); // 랜덤 색상 추가
            winningLottoSelNoDiv.appendChild(numDiv); // 부모 div에 추가
        });
    };
</script>

<script type="text/javascript">
let globalMatchCount = 0;
let lottoSelNoArray2 = 0;
function makeLottoNo() {
    $.ajax({
        url: '/lotto/make',
        method: 'POST',
        success: function (data) {
            let memberSelNo = data;
            let memberSelNoArray = Array.isArray(memberSelNo) ? memberSelNo : JSON.parse(memberSelNo);
            
            // 오름차순 정렬
            memberSelNoArray.sort((a, b) => a - b);
            
            lottoSelNoArray2 = memberSelNoArray;
            
            const memberLottoSelNoDiv = document.getElementById("memberLottoSelNo");
            memberLottoSelNoDiv.innerHTML = ""; // 기존 내용 제거

            memberSelNoArray.forEach(num => {
                const numDiv = document.createElement("div");
                numDiv.className = "lottoNumber";
                numDiv.textContent = num;
                numDiv.style.backgroundColor = getRandomColor();
                memberLottoSelNoDiv.appendChild(numDiv);
            });

            // 번호 비교 및 결과 표시
            const matchingNumbers = compareLottoNumbers(lottoSelNoArray, memberSelNoArray);

            if (Array.isArray(matchingNumbers)) {
                displayMatchResult(matchingNumbers);
            } else {
                console.error("matchingNumbers is not an array", matchingNumbers);
            }
        },
        error: function(xhr, status, error) {
            alert('Error: ' + status + ' - ' + error);
        }
    });
}

function compareLottoNumbers(winningNumbers, userNumbers) {
    // 일치하는 번호를 배열로 반환
    const matching = winningNumbers.filter(num => userNumbers.includes(num));
    return matching;
}

function displayMatchResult(matchingNumbers) {
    const resultDiv = document.getElementById("matchResult");
    if (!resultDiv) {
        console.error("matchResult element not found");
        return;
    }

    resultDiv.innerHTML = ""; // 기존 내용 제거

    // matchCount를 전역 변수에 할당
    globalMatchCount = matchingNumbers.length;

    let resultText;
    if (globalMatchCount > 3) {
        resultText = "축하합니다! 1등입니다: " + matchingNumbers.join(", ");
    }else if (globalMatchCount == 2) {
        resultText = "축하합니다! 2등입니다: " + matchingNumbers.join(", ");
    }else if (globalMatchCount == 1) {
        resultText = "축하합니다! 3등입니다: " + matchingNumbers.join(", ");
    }else {
        resultText = "아쉽지만 다음기회에~";
    }

    const textNode = document.createTextNode(resultText);
    resultDiv.appendChild(textNode);

    resultDiv.style.fontSize = "24px";
    resultDiv.style.fontWeight = "bold";
    resultDiv.style.marginTop = "20px";
    resultDiv.style.textAlign = "center";
    
    insertMemberLotto();
}

function insertMemberLotto() {
    var lottoMode = parseInt($('#authority').val(), 10); 
    var memberNo = parseInt($('#memberNo').val(), 10);
    var lottoSelNo = JSON.stringify(lottoSelNoArray2); // 배열을 JSON 문자열로 변환
    var lottoRound = parseInt($('#lottoRound').val(), 10);
    var lottoWinning = globalMatchCount; // 매치 카운트

    var lottoData = {
        memberNo: memberNo,
        lottoMode: lottoMode, 
        lottoRound: lottoRound,
        lottoSelNo: lottoSelNo,
        lottoWinning: lottoWinning
    };

    $.ajax({
        url: '/lotto/add2',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(lottoData),
        success: function (data) {
            alert("추첨이 완료되었습니다");
            
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('Error: ' + status + ' - ' + error);
        }
    });
}




</script>	
<script src="/js/event/lotto/lottoDetail.js"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/Header.jsp"/> 
    <input type="hidden" id="memberNo" name="memberNo" value="${memberVo.memberNo}">
	<input type="hidden" id="authority" name="authority" value="${memberVo.authority}">
	<input type="hidden" id="lottoRound" name="lottoRound" value="${lottoVo.lottoRound}">
    <div id="lottoContainer">
        <div>
            <div class="detailHeader">
                <p>${lottoVo.lottoRound} 회차
                    <span class="dateSpan">${lottoVo.lottoStartDate} / ${lottoVo.lottoEndDate}</span>
                </p>
            </div>
            <div class="detailBody">
                <div class="winningLottoSelNo" id="winningLottoSelNo">
                    <!-- 로또 번호가 여기 출력됩니다 -->
                </div>
            </div>
            
            <div class="detailHeader">
                <p>${memberVo.memberName}님이 뽑은번호</p>
            </div>
            <div class="detailBody">
                <div class="memberLottoSelNo" id="memberLottoSelNo">
                    
                </div>
            </div>                   
            <div class="matchUp">
            	<div id="matchResult"></div>
            </div>  
            <div class="reminderDiv">
        		<ul>
	   				<li>※3개이상 맞추시면 1등! 1만 포인트 증정입니다.</li>
	   				<li>※2개이상 맞추시면 2등! 5천 포인트 증정입니다.</li>
	   				<li>※1개이상 맞추시면 3등! 3천 포인트 증정입니다.</li>
	   				<li>※본 이벤트는 회차당 세번가능합니다.</li>
	   			</ul>
   			</div>
            <div class="btnDiv">
            	<c:if test="${memberVo.authority == 0}">
            		<button class="btn2" type="button" onclick="makeLottoNo();">뽑기</button>
            	</c:if>                
                <button class="btn2" type="button" onclick="pageMoveList();">돌아가기</button>
            </div>
            
           
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>
