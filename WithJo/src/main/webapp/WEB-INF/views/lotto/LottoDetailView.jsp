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
<style>
    /* 스타일 추가 */
    .winningLottoSelNo {
        display: flex;
        justify-content: center; /* 가운데 정렬 */
        gap: 10px; /* 동그라미 간격 */
    }
    
    .lottoNumber {
        width: 100px; /* 원의 너비 */
        height: 100px; /* 원의 높이 */
        border-radius: 50%; /* 동그라미 */
        display: flex;
        align-items: center; /* 세로 중앙 정렬 */
        justify-content: center; /* 가로 중앙 정렬 */
        color: white; /* 글자 색 */
        font-weight: bold; /* 글자 두껍게 */
        font-size: 50px;
    }
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
<script src="/js/event/lotto/lottoDetail.js"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/Header.jsp"/> 
    
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
            
            <div class="btnDiv">
                 <button type="btn2" onclick="pageMoveUpdate();" class="btn2">뽑기</button>
                <button class="btn2" type="button" onclick="pageMoveList();">돌아가기</button>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>
