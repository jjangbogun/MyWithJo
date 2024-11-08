<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMoney</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
	rel="stylesheet">
<!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/member/memberEMoney.css">
<script defer src="/js/common/common.js"></script>
<script defer src="/js/member/memberEMoney.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


</head>
<body>

	<jsp:include page="/WEB-INF/views/Header.jsp" />


	<div id="mainContainer">

		<div class="aboutPage">
			<div class="pageTitle">
				<span>EMoney</span>
			</div>
			<!-- pageTitle -->

		</div>
		<!-- aboutPage -->

		<div class="myPageCategory">
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn" onclick="myPageCategoryBtnFnc(${memberVo.memberNo},1);" value="1">내 수강 목록</button></span>
			</div>
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn" onclick="myPageCategoryBtnFnc(${memberVo.memberNo},2);" value="2">EMoney</button></span>
			</div>
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn" onclick="myPageCategoryBtnFnc(${memberVo.memberNo},3);" value="3">회원정보변경</button></span>
			</div>
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn" onclick="myPageCategoryBtnFnc(${memberVo.memberNo},4);" value="4">장바구니</button></span>
			</div>
		</div>
		
		<div>			
			<h2>현재 잔액: ${eMoneyList[0].memberEMoney}</h2>
   			<h3>거래 내역:</h3>
   			<c:forEach var="eMoney" items="${eMoneyList}">
      			<p>날짜: <fmt:formatDate value="${eMoney.memberEMoneyUpdate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
      			<p>입금: ${eMoney.memberEMoneyPlus}</p>
      			<p>입금 상세: ${eMoney.memberEMoneyPlusDetail}</p>
      			<p>출금: ${eMoney.memberEMoneyMinus}</p>
       			<p>출금 상세: ${eMoney.memberEMoneyMinusDetail}</p>
       			<hr>
    		</c:forEach>
		</div>

		

	</div>
	<!-- main-container -->

	<jsp:include page="/WEB-INF/views/Footer.jsp" />


</body>
</html>