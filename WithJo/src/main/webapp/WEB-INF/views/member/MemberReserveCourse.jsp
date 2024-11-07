<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 수강 목록</title>
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
<link rel="stylesheet" href="/css/member/memberReserve.css">
<script defer src="/js/common/common.js"></script>
<script defer src="/js/member/memberReserve.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	var memberNo = ${sessionScope.memberVo.memberNo};	
</script>


</head>
<body>

	<jsp:include page="/WEB-INF/views/Header.jsp" />


	<div id="mainContainer">

		<div class="aboutPage">
			<div class="pageTitle">
				<span>마이페이지</span>
			</div>
			<!-- pageTitle -->

		</div>
		<!-- aboutPage -->

		<div class="myPageCategory">
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn">내 수강 목록</button></span>
			</div>
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn">포인트 내역</button></span>
			</div>
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn">회원정보변경</button></span>
			</div>
			<div class="myPageCategory__element">
				<span><button class="myPageCategoryBtn">장바구니</button></span>
			</div>
		</div>
		
		<div class="myReserveList">		
						
			<c:forEach var="reserve" items="${reserveList}">
  				  <p>${reserve.courseName}</p>
  				  <p>${reserve.courseStartDate}</p>
  				  <p>${reserve.courseEndDate}</p>
  				  <p>${reserve.courseStartTime}</p>
  				  <p>${reserve.courseEndTime}</p>
   			      <p>${reserve.courseDayOfTheWeek}</p>
  				  <p>${reserve.courseTeacher}</p>
			</c:forEach>
			
		</div>
		

		

	</div>
	<!-- main-container -->

	<jsp:include page="/WEB-INF/views/Footer.jsp" />


</body>
</html>