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

		<div class="myReserveList">
			<div class="myReserveList-header">
				<div class="header-item">강의명</div>
				<div class="header-item">강의시간/기간</div>
				<div class="header-item">강사명</div>
				<div class="header-item">수강취소</div>
			</div>

			<c:forEach var="reserve" items="${reserveList}">
				<div class="myReserveList-item">
					<div class="item-content">
						<div class="course-name">
							<img src="${reserve.courseMainImage}" alt="강의 이미지">
							${reserve.courseName}
						</div>
					</div>
					<div class="item-content">
						[
						<c:choose>
							<c:when test="${reserve.courseDayOfTheWeek == '1'}">월</c:when>
							<c:when test="${reserve.courseDayOfTheWeek == '2'}">화</c:when>
							<c:when test="${reserve.courseDayOfTheWeek == '3'}">수</c:when>
							<c:when test="${reserve.courseDayOfTheWeek == '4'}">목</c:when>
							<c:when test="${reserve.courseDayOfTheWeek == '5'}">금</c:when>
							<c:when test="${reserve.courseDayOfTheWeek == '6'}">토</c:when>
							<c:when test="${reserve.courseDayOfTheWeek == '7'}">일</c:when>
							<c:otherwise>${reserve.courseDayOfTheWeek}</c:otherwise>
						</c:choose>
						]
						<fmt:formatDate value="${reserve.courseStartDate}" pattern="yyyy.MM.dd" />
						~
						<fmt:formatDate value="${reserve.courseEndDate}" pattern="yyyy.MM.dd" />
						<br> ${reserve.courseStartTime} ~ ${reserve.courseEndTime}
					</div>
					<div class="item-content">${reserve.courseTeacher} 강사</div>
					<div class="item-content">
						<button class="reserveCancel" onclick="cancelCourse(${reserve.memberCourseReserveNo})">수강취소</button>
					</div>
				</div>
			</c:forEach>
		</div>




	</div>
	<!-- main-container -->

	<jsp:include page="/WEB-INF/views/Footer.jsp" />


</body>
</html>