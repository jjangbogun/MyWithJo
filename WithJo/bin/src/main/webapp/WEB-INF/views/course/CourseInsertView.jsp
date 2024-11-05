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
<title>Insert title here</title>
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
  rel="stylesheet">
 <!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/course/courseInsert.css">
<!--  페이지 js -->
<script defer src="/js/common/common.js"></script>
<script defer src="/js/course/courseDetail.js"></script>

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
														<p>
															<span class="courseImBox">
																<img class="courseImg" alt="." src="/img/course/swin.png">
															</span>
														</p>
													</div>
													<div class="courseInfoTitleSub">
														<input type="text">
													</div>
												</div>
												<div class="courseInfoSub">
													<div class="courseInfoSubElement teacher">
														<div class="courseInfoSubElement--flex title">
															<span>강사명</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="text">
														</div>
													</div>
													<div class="courseInfoSubElement aboutCourseDate">
														<div class="courseInfoSubElement--flex title">
															<span>강의기간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="date">
															<span>~</span>
															<input type="date">
														</div>
													</div>
													<div class="courseInfoSubElement aboutCourseDay">
														<div class="courseInfoSubElement--flex title">
															<span>강의시간</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="text"><br>
															<input type="text">
															<span>~</span>
															<input type="text">
														</div>
													</div>
													<div class="courseInfoSubElement cost">
														<div class="courseInfoSubElement--flex title">
															<span>수강비용</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="text">
														</div>
													</div>
													<div class="courseInfoSubElement current">
														<div class="courseInfoSubElement--flex title">
															<span>수강정원</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<input type="text">
														</div>
													</div>
													<div class="courseInfoSubElement age">
														<div class="courseInfoSubElement--flex title">
															<span>나이제한</span>
														</div>
														<div class="courseInfoSubElement--flex detail">
															<select>
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
															<input type="date">
															<span>~</span>
															<input type="date">
														</div>
													</div>
												</div>
											</div>
										</div><!-- rightBoxInfoInner -->
										
									</div><!-- rightBoxInfo -->
								</div> <!-- rightBoxFloat -->
							</div> <!-- rightBox -->
							<div class="infoBox">
								<p>
									<span class="courseImBox">
										<img class="courseImg" alt="." src="/img/course/swin.png">
									</span>
								</p>
								<div class="courseInfoText">
									<P style="font-family: '맑은 고딕';font-size: 16pt;font-weight: 700;">
										<span style="background-color:rgb(128 145 188 / 29%);"></span>
									</p>
									<p>
										<span></span>
									</p>
									<div>
										<textarea rows="10" cols="100" style="height: 980px;"></textarea>										
									</div>
								</div>
							</div> <!-- infoBox -->
						</div><!-- courseInner -->
					</div> <!-- courseDetailInnerBox -->
				</div> <!-- courseDetailBox -->
				<input type="hidden" value="${sessionScope.memberVo.authority}" class="memberVo">
				<input type="hidden" value="${sessionScope.memberVo.memberNo}" class="memberNo">
				<c:if test="${sessionScope.memberVo.authority eq 1}">
					<div class="admin">
						<div>
							<button>강의수정</button>
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