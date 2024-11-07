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
<body>
	
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="lottoAddContainer">
		
		<input type="hidden" id="memberNo" name="memberNo" value="${memberVo.memberNo}">
		<input type="hidden" id="authority" name="authority" value="${memberVo.authority}">
		    
		    <div>
		        <label for="lottoRound">로또회차</label><br>
		        <input type="number" id="lottoRound" name="lottoRound"><br>
		    </div>
		    
		    <div>
		        <label for="lottoStartDate">회차시작날짜</label><br>
		        <input class="dateInput" type="date" id="lottoStartDate" name="lottoStartDate"><br>
		    </div>
		    
		    <div>
		        <label for="lottoEndDate">회차종료날짜</label><br>
		        <input class="dateInput" type="date" id="lottoEndDate" name="lottoEndDate"><br>
		    </div>
		    
		    <div>
		        <label for="lottoEndDate">당첨금액설정</label><br>
		        <div>
		        	<table class="lottoRankTb">
		        		<tr class="lottoRankTr">
		        			<td class="lottoRankTdHead">1등</td>
		        			<td class="lottoRankTd">
		        				<input class="pointInput" type="number" id="lotto1st" name="lotto1st">
		        			</td>
		        		</tr>
		        		<tr>
		        			<td class="lottoRankTdHead">2등</td>
		        			<td class="lottoRankTd">
		        				<input class="pointInput" type="number" id="lotto2nd" name="lotto2nd">
		        			</td>
		        		</tr>
		        		<tr>
		        			<td class="lottoRankTdHead">3등</td>
		        			<td class="lottoRankTd">
		        				<input class="pointInput" type="number" id="lotto3rd" name="lotto3rd">
		        			</td>	        		
		        		</tr>
		        	</table>
		        </div>
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