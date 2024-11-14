<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
  rel="stylesheet">
<!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<link rel="stylesheet" href="https://use.typekit.net/vvo0ldr.css">

<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script defer src="/js/common/common.js"></script>
</head>
<body>
		<jsp:include page="/WEB-INF/views/Header.jsp"/> 
		<div id="mainContainer">
			<div class="mainPageBox">
				<div class="mainPageBoxFlex">
					<div class="mainNotice">
						<img alt="이미지 준비중" src="img/common/mainNotice.png">
					</div>
					<div class="course_end_box">
						<div>
							<p>마감임박</p>
						</div>
						<div>
							<p>강의신청이 곧 마감돼요!</p>
						</div>
						<div class="swiperBox">
							 <div class="swiper mySwiper">
							    <div class="swiper-wrapper">
							    	<c:forEach var="courseVo" items="${courseList}">
							    	<input type="hidden" value="${courseVo.courseRecEnd}"class="courseRecEnd">
							    	<c:set var="now" value="<%=new java.util.Date() %>"/>
									    <div class="swiper-slide">
									    	<div>
									    		<img src="/imges/${courseVo.courseMainImage}" alt=""/>
									    	</div>
									    	<div>
									    		<div>
									    		</div>
									    	</div>
									    </div>
							     	</c:forEach>
							    </div>
							    <div class="swiper-button-next"></div>
							    <div class="swiper-button-prev"></div>
							 </div>
						</div>
					</div>
					<div>
					
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>