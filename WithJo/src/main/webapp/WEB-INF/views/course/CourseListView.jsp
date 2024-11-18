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
<title>수강신청관리</title>
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
  rel="stylesheet">
 <!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/course/courseList.css">
<link rel="stylesheet" href="https://use.typekit.net/vvo0ldr.css">
<!--  페이지 js -->
<script defer src="/js/common/common.js"></script>
<script defer src="/js/course/courseList.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/>
	
		<div id="mainContainer">
			
			<div class="aboutPage">
				<div class="pageTitle">
					<span>수강신청</span>
				</div><!-- pageTitle -->
				
			</div><!-- aboutPage -->
			<div class="courseListInfo">
				<div class="courseListInfo--flex">
			
					<div class="ageCategory ageCategoryBorder">
							<div class="ageElement All">
								<a class="ageCategoryBtn" name="all" onclick="moveCategoryFnc(0);"><span>전체</span></a>
							</div>
							<div class="ageElement baby">
								<a class="ageCategoryBtn" name="baby" onclick="moveCategoryFnc(13);"><span>유아</span></a>
							</div>
							<div class="ageElement youth">
								<a class="ageCategoryBtn" name="youth" onclick="moveCategoryFnc(19);"><span>청소년</span></a>
							</div>
							<div class="ageElement adult">
								<a class="ageCategoryBtn" name="adult" onclick="moveCategoryFnc(20);"><span>성인</span></a>
							</div>
							<div class="categorySelectList">
							</div>
					</div><!-- ageCategory -->
					<c:if test="${sessionScope.memberVo.authority eq 1}">
							<div class="admin">
								<div class="adminCourseInsert">
									<button class="adminCourseInsertBtn" onclick="courseInsert();">강의등록</button>
								</div>
								<div class="adminCourseDelete">
									<button class="adminCourseDeleteBtn" onclick="courseDeleteFnc();">강의삭제</button>
								</div>
							</div>
					</c:if>
					<div >
						<div class="courseListBox">
							<div class="courseFlexBox">
								<c:forEach var="courseVo" items="${courseList}">
									<c:if test="${courseVo.courseHide eq 0}">
										<div class="courseTxtFlex">
											<div class="checkbox--dis">
												<input type="checkbox" value="${courseVo.courseNo}" class="checkbox">
											</div>
											<div class="courseBox">
												<input class="numHidden" type="hidden" value="${courseVo.courseNo}">
												<div class="mainImg">
													<img alt="." src="/imges/${courseVo.courseMainImage}" class="mainImgHover">
												</div>
												<input type="hidden" class="courseCurrentPeopleHidden" value="${courseVo.courseCurrentPeople}">
												<input type="hidden" class="courseMaxPeopleHidden" value="${courseVo.courseMaxPeople}">
												<div class="course-Ing">
																<c:set var="now" value="<%=new java.util.Date() %>"/>
																	<!--<fmt:formatDate value="${courseVo.courseRecStart}" pattern="yyyy-MM-dd hh:mm:ss" var="startrRecDate"/>-->
																	<c:if test="${now > courseVo.courseRecStart and now < courseVo.courseRecEnd}">
																		<div class="courseRecStart">
																			<span class="courseRecStartLabel">접수중</span>
																		</div>
																	</c:if>
																	<c:if test="${now < courseVo.courseRecStart}">
																		<div class="courseRecStartWait">
																			<span class="courseRecStartWaitLabel">접수대기중</span>
																		</div>
																	</c:if>
																	<c:if test="${now > courseVo.courseRecEnd and now > courseVo.courseRecStart}">
																		<div class="courseRecEnd">
																			<span class="courseRecEndWaitLabel">마감</span>
																		</div>
																	</c:if>
															</div>
													<div class="courseInfoElement">
											    		<div class="courseName">
											    			<p>${courseVo.courseName}</p>
											    		</div>
											    		<div class="courseInfoElementTxt">
											    			<div class="courseTeacher">
												    			<p>${courseVo.courseTeacher}강사</p>
												    		</div>
												    		<div class="courseTimeTxt">
												    			<div>
													    			<img alt="." src="/img/common/time.png">
													    		</div>
												    			<div>
													    			<p>${courseVo.courseStartTime}</p>
													    		</div>
													    		<div>
													    			<p>~</p>
													    		</div>
													    		<div>
													    			<p> ${courseVo.courseEndTime}</p>
													    		</div>
													    	</div>
													    	<div>
												    			<p class="costDetail">${courseVo.courseCost}원</p>
												    		</div>
												    </div>
										    	</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</div>
						</div>
						
					</div><!-- courseCategory -->
				</div>
			</div>
			
		</div> <!--mainContainer-->
		
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>