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
<title>메인페이지</title>
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
  rel="stylesheet">
<!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/common/index.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<link rel="stylesheet" href="https://use.typekit.net/vvo0ldr.css">

<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script defer src="/js/common/common.js"></script>
<script defer src="/js/common/index.js"></script>
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
						<div class="course_end--flex">
							<div class="course_end_txt1">
								<p>마감임박</p>
							</div>
							<div class="course_end_txt2">
								<p>강의신청이 곧 마감돼요!</p>
							</div>
						</div>
						<div class="swiperBox">
							 <div class="swiper mySwiper">
							    <div class="swiper-wrapper">
							    	<c:forEach var="courseRecList" items="${courseRecList}">
							    	<c:set var="now" value="<%=new java.util.Date() %>"/>
									    <div class="swiper-slide">
									    <input type="hidden" value="${courseRecList.courseRecEnd}">
									    <input type="hidden" value="${courseRecList.courseNo}" class="courseNo">
									    	<div class="mainImg">
									    		<img class="mainImgHover" src="/imges/${courseRecList.courseMainImage}" alt=""/>
									    	</div>
									    	<div class="indexCourseInfoBox">
										    	<div class="courseRecStart">
													<span class="courseRecStartLabel">접수중</span>
												</div>
										    	<div class="courseInfoElement">
										    		<div class="courseName">
										    			<p>${courseRecList.courseName}</p>
										    		</div>
										    		<div class="courseInfoElementTxt">
										    			<div class="courseTeacher">
											    			<p>${courseRecList.courseTeacher}강사</p>
											    		</div>
											    		<div class="courseTimeTxt">
											    			<div>
												    			<img alt="." src="/img/common/time.png">
												    		</div>
											    			<div>
												    			<p>${courseRecList.courseStartTime}</p>
												    		</div>
												    		<div>
												    			<p>~</p>
												    		</div>
												    		<div>
												    			<p> ${courseRecList.courseEndTime}</p>
												    		</div>
												    	</div>
												    	<div>
											    			<p class="courseRecEnd">마감일 : <fmt:formatDate value="${courseRecList.courseRecEnd}" pattern="yyyy-MM-dd"/> </p>
											    		</div>
												    </div>
										    	</div>
										    	<div class="costBox">
									    			<div>
										    			<p class="costDetail">${courseRecList.courseCost}원</p>
										    		</div>
										    		<div class="shoppingCart">
										    			<a><img alt="." src="/img/common/shoppingCart.png"></a>
										    		</div>
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
					<div class="noticeBox">
						<div class="noticeBox-flex">
							<c:forEach var="noticeItem" items="${noticeList}">						
								<a class="noticeBoxElementTxt" href="/notice/detail?noticeNo=${noticeItem.noticeNo}" >
									<div class="noticeBoxElement_txt_box">
										<div class="noticeBoxElement_txt title">
											<p>[공지사항] ${noticeItem.noticeTitle}</p>
										</div>
										<div class="noticeBoxElement_txt content txt_line">
											<p>${noticeItem.noticeContent}</p>
										</div>
									</div>
									<div class="noticeBoxElement_txt credate">
										<p><fmt:formatDate value="${noticeItem.noticeCredate}" pattern="yyyy.MM.dd"/></p>
									</div>
								</a>						
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>