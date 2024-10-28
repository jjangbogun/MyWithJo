<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>강의디테일리스트</title>
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
 <!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/course/courseDetail.css">
<!--  페이지 js -->
<script defer src="/js/common/common.js"></script>
<script defer src="/js/course/courseDetail.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/>
		<div id="mainContainer">
			<div class="courseDetailBox">
				<div class="courseDetailInnerBox">
					<div class="inner">
						<div class="rightBox">
							<div class="rightBoxFloat">
								<div class="rightBoxInfo">
										<div class="rightBoxInfoInner">
											<div class="scrollArea">
												<div class="course-Ing">
													<c:set var="now" value="<%=new java.util.Date() %>"/>
														<!--<fmt:formatDate value="${courseVo.courseRecStart}" pattern="yyyy-MM-dd hh:mm:ss" var="startrRecDate"/>-->
														<c:if test="${now > courseVo.courseRecStart}">
															<div class="courseRecStart">
																<span class="courseRecStartLabel">접수중</span>
															</div>
														</c:if>
														<c:if test="${now > courseVo.courseRecEnd}">
															<div class="courseRecEnd">
																<span>마감</span>
															</div>
														</c:if>
												</div>
												<div class="courseInfoTitle">
													<div class="courseInfoTitleImg">
														<p>
															<span class="courseImBox">
																<img class="courseImg" alt="." src="/img/course/swin.png">
															</span>
														</p>
													</div>
													<div class="courseInfoTitleSub">
														<p>
															[<fmt:formatDate value="${courseVo.courseStartDate}" pattern="MM/dd" />]
															${courseVo.courseName}
														</p>
													</div>
												</div>
												<div class="courseInfoSub">
													<div class="courseInfoSubElement teacher">
														<div class="courseInfoSubElement--flex title">
															<span>강사명</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<span>${courseVo.courseTeacher}</span>
														</div>
													</div>
													<div class="courseInfoSubElement aboutCourseDate">
														<div class="courseInfoSubElement--flex title">
															<span>강의기간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<span><fmt:formatDate value="${courseVo.courseStartDate}" pattern="yyyy.MM.dd" /></span>
															<span>~</span>
															<span><fmt:formatDate value="${courseVo.courseEndDate}" pattern="yyyy.MM.dd" /></span>
														</div>
													</div>
													<div class="courseInfoSubElement aboutCourseDay">
														<div class="courseInfoSubElement--flex title">
															<span>강의시간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															[<c:forEach var="item" items="${courseDay.courseDay}">
																<span class="courseDayOfTheWeek">
																	<c:choose>
															            <c:when test="${item.courseDayOfTheWeek == '1'}">월</c:when>
															            <c:when test="${item.courseDayOfTheWeek == '2'}">화</c:when>
															            <c:when test="${item.courseDayOfTheWeek == '3'}">수</c:when>
															            <c:when test="${item.courseDayOfTheWeek == '4'}">목</c:when>
															            <c:when test="${item.courseDayOfTheWeek == '5'}">금</c:when>
															            <c:when test="${item.courseDayOfTheWeek == '6'}">토</c:when>
															            <c:when test="${item.courseDayOfTheWeek == '7'}">일</c:when>
															            <c:otherwise>${item.courseDayOfTheWeek}</c:otherwise>
															        </c:choose>
																</span>
															</c:forEach>
															]
															<span class="courseStartTime">${courseVo.courseStartTime}</span>
															<span>~</span>
															<span class="courseEndTime">${courseVo.courseEndTime}</span>
														</div>
													</div>
													<div class="courseInfoSubElement cost">
														<div class="courseInfoSubElement--flex title">
															<span>수강비용</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<span>${courseVo.courseCost}</span>
														</div>
													</div>
													<div class="courseInfoSubElement current">
														<div class="courseInfoSubElement--flex title">
															<span>수강정원</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<span>${courseVo.courseCurrentPeople}</span>
															<span>/</span>
															<span>${courseVo.courseMaxPeople}</span>
														</div>
													</div>
													<div class="courseInfoSubElement age">
														<div class="courseInfoSubElement--flex title">
															<span>나이제한</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<span>${courseVo.courseAgeLimit}</span>
														</div>
													</div>
													<div class="courseInfoSubElement endCourse">
														<div class="courseInfoSubElement--flex title">
															<span>접수기간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<span><fmt:formatDate value="${courseVo.courseRecStart}" pattern="yyyy.MM.dd" /></span>
															<span>~</span>
															<span><fmt:formatDate value="${courseVo.courseRecEnd}" pattern="yyyy.MM.dd" /></span>
														</div>
													</div>
												</div>
											</div>
										</div><!-- rightBoxInfoInner -->
										<div class="courseReservation">
											
										</div>
								</div> <!-- rightBoxInfo -->
							</div>
							<div class="infoBox">
								<p>
									<span class="courseImBox">
										<img class="courseImg" alt="." src="/img/course/swin.png">
									</span>
								</p>
								<div class="courseInfoText">
									<P style="font-family: '맑은 고딕';font-size: 16pt;font-weight: 700;">
										<span style="background-color:rgb(128 145 188 / 29%);">${courseVo.courseName}</span>
									</p>
									<p>
										<span>${courseVo.courseTeacher}
										</span>
									</p>
									<div>
										<!--<span>${courseVo.courseInfo}</span>-->
										<p style="text-align: center;"><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
										<p><span>테니스를 배워봅시</span></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		
		</div> <!--mainContainer-->
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>