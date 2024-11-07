<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
  rel="stylesheet">
 <!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/course/courseInsert.css">
<link rel="stylesheet" type="text/css" href="/plugin/sumoselect/sumoselect.min.css"/>
<!--  페이지 js -->
<script defer src="/js/common/common.js"></script>
<script defer src="/js/course/courseDetail.js"></script>
<script defer src="/js/course/courseInsert.js"></script>
<script defer src="/plugin/sumoselect/jquery.sumoselect.min.js"></script>

</head>

<body>
<jsp:include page="/WEB-INF/views/Header.jsp"/>
		<div id="mainContainer">
			<div class="courseDetailBox">
				<div class="courseDetailInnerBox">
					<div class="courseInner">
						<div class="rightBox">
							<div class="rightBoxFloat">
								<div class="rightBoxInfo">
										<div class="rightBoxInfoInner">
											<div class="scrollArea">
												<div class="courseInfoTitle">
													<div class="courseInfoTitleImg">
													</div>
													<div class="courseInfoTitleSub">
														<input type="text" class="courseTitle" name="courseName">
													</div>
												</div>
												<div class="courseInfoSub">
													<div class="courseInfoSubElement teacher">
														<div class="courseInfoSubElement--flex title">
															<span>강사명</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="text" class="courseTeacher" name="courseTeacher">
														</div>
													</div>
													<div class="courseInfoSubElement aboutCourseDate">
														<div class="courseInfoSubElement--flex title">
															<span>강의기간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="date" class="courseStartDate" name="courseStartDate">
															<span>~</span>
															<input type="date" class="courseEndDate" name="courseEndDate">
														</div>
													</div>
													<div class="courseInfoSubElement aboutCourseDay">
														<div class="courseInfoSubElement--flex title">
															<span>강의시간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="hidden" value="" name="courseDayOfTheWeek" class="selectedSub">
															<select id="sumoSelectId" name="sumoSelectName" multiple="multiple" class="sumoselect_multiple">
																<option value="1">월</option>
																<option value="2">화</option>
																<option value="3">수</option>
																<option value="4">목</option>
																<option value="5">금</option>
															</select><br>
															<select class="timeOption courseStartTime" name="courseStartTime">
																<option class="timeOptions">09:00</option>
															</select>
															<span>~</span>
															<select class="timeOption courseEndTime" name="courseEndTime">
																<option class="timeOption">09:00</option>
															</select>
														</div>
													</div>
													<div class="courseInfoSubElement cost">
														<div class="courseInfoSubElement--flex title">
															<span>수강비용</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="text" class="courseCost" name="courseCost">
														</div>
													</div>
													<div class="courseInfoSubElement current">
														<div class="courseInfoSubElement--flex title">
															<span>수강정원</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="text" class="courseMax" name="courseMaxPeople">
														</div>
													</div>
													<div class="courseInfoSubElement category">
														<div class="courseInfoSubElement--flex title">
															<span>과목분류</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<select class="courseSubjectsSelect" name="categoryNo">
																<option disabled selected>과목</option>
																<option value="1">수영</option>
																<option value="2">테니스</option>
																<option value="3">탁구</option>
																<option value="4">골프</option>
																<option value="5">요가</option>
															</select>
														</div>
													</div>
													<div class="courseInfoSubElement age">
														<div class="courseInfoSubElement--flex title">
															<span>나이제한</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<select class="courseAgeSelect" name="courseAgeLimit">
																<option disabled selected>나이제한</option>
																<option>13</option>
																<option>19</option>
																<option>20</option>
															</select>
														</div>
													</div>
													<div class="courseInfoSubElement endCourse">
														<div class="courseInfoSubElement--flex title">
															<span>접수기간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="date" class="courseRecStart" name="courseRecStart">
															<span>~</span>
															<input type="date" class="courseRecEnd" name="courseRecEnd">
														</div>
													</div>
												</div>
											</div>
										</div><!-- rightBoxInfoInner -->
										
									</div><!-- rightBoxInfo -->
								</div> <!-- rightBoxFloat -->
							</div> <!-- rightBox -->
							<div class="infoBox">
								<div>
									<input type="file" id="fileData" name="courseMainImage" required>
								</div>
								<div class="courseInfoText">
									<P style="font-family: '맑은 고딕';font-size: 16pt;font-weight: 700;">
										<span style="background-color:rgb(128 145 188 / 29%);"></span>
									</p>
									<p>
										<span></span>
									</p>
									<div class="courseSubInfo">
										<textarea rows="10" cols="90" style="height: 980px;" name="courseInfo"></textarea>										
									</div>
								</div>
							</div> <!-- infoBox -->
						</div><!-- courseInner -->
					</div> <!-- courseDetailInnerBox -->
				</div> <!-- courseDetailBox -->
				<input type="hidden" value="${sessionScope.memberVo.authority}" class="memberVo">
				<input type="hidden" value="${sessionScope.memberVo.memberNo}" class="memberNo">
				<input type="hidden" value="${courseVo.courseNo}" class="courseNo">
				<c:if test="${sessionScope.memberVo.authority eq 1}">
					<div class="admin">
						<div>
							<button class="courseInsertPost" onclick="courseInsertPost();">강의등록</button>
						</div>
						<div>
							<button onclick="moveCourseList();">돌아가기</button>
						</div>
					</div>
				</c:if>
		</div> <!-- mainContainer -->
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>