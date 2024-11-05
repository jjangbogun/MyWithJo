<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또하기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/event/lotto/lottoDetail.css">
<script defer src="/js/common/common.js"></script>
<script src="/js/event/lotto/lottoDetail.js"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/Header.jsp"/>
    <input type="hidden" id="memberNo" name="memberNo" value="${memberVo.memberNo}">
    <input type="hidden" id="authority" name="authority" value="${memberVo.authority}">
    <input type="hidden" id="lottoRound" name="lottoRound" value="${lottoVo.lottoRound}">
    <input type="hidden" id="lottoSelNoStr" name="lottoSelNoStr" value="${lottoVo.lottoSelNo}">
    <div id="lottoContainer">
        <div>
        	<div class="btnDiv">
	    		<c:if test="${memberVo.authority >= 1}">
					<button class="btn2" type="button" onclick="pageMoveLottoList();">추첨번호 관리</button>
	            </c:if>	            
	    	</div>
            <div class="detailHeader">
                <p>${lottoVo.lottoRound} 회차
                    <span class="dateSpan">${lottoVo.lottoStartDate} / ${lottoVo.lottoEndDate}</span>
                </p>
            </div>
            <div class="detailBody">
                <div class="winningLottoSelNo" id="winningLottoSelNo"></div>
            </div>
            <c:if test="${memberVo.authority == 0}">         
	            <div class="detailHeader">
	                <p>${memberVo.memberName}님이 뽑은번호</p>
	            </div>
	            <div class="detailBody">
	                <div class="memberLottoSelNo" id="memberLottoSelNo"></div>
	            </div>                   
	            <div class="matchUp">
	                <div id="matchResult"></div>
	            </div>  
	            <div class="reminderDiv">
	                <ul>
	                    <li>※3개이상 맞추시면 1등! 1만 포인트 증정입니다.</li>
	                    <li>※2개이상 맞추시면 2등! 5천 포인트 증정입니다.</li>
	                    <li>※1개이상 맞추시면 3등! 3천 포인트 증정입니다.</li>
	                    <li>※본 이벤트 기한은 변경될 수 있습니다.</li>
	                    <li>※본 이벤트는 회차당 다섯번 가능합니다.</li>
	                </ul>
	            </div>           
            </c:if>
            <div class="btnDiv">
            	<c:if test="${memberVo.memberNo == null}">
            		<div class="loginNotice">
            			<p>로그인이 필요합니다.</p>
            		</div>
            	</c:if>
                <c:if test="${memberVo.authority == 0}">
                    <button class="btn2" type="button" onclick="memberCountCheck();">뽑기</button>
                </c:if>    
                <button class="btn2" type="button" onclick="pageMoveEventList();">돌아가기</button>             
            </div>      
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>