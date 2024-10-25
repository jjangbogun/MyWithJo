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
		
			<div class="aboutPage">
				<div class="pageTitle">
					<span>수강신청</span>
				</div><!-- pageTitle -->
			</div><!-- aboutPage -->
			
			<div class="courseDetailBox">
				<div class="courseDetailInnerBox">
					<div class="inner">
						<div class="rightBox">
							<div class="rightBoxFloat">
								<div class="rightBoxInfo">
									<div class="course-Ing">
										<c:set var="now" value="<%=new java.util.Date() %>"/>
											<!--<fmt:formatDate value="${courseVo.courseRecStart}" pattern="yyyy-MM-dd hh:mm:ss" var="startrRecDate"/>-->
											<c:if test="${now > courseVo.courseRecStart}">
												신청중
											</c:if>
									</div>
									<div></div>
									<div></div>
								</div>
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