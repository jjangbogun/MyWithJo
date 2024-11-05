<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
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
<link rel="stylesheet" href="/css/member/memberUpdate.css">
<script defer src="/js/common/common.js"></script>
<script defer src="/js/member/memberUpdate.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	
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

		<div class="myPagetCategory">
			<div class="myPagetCategory__element">
				<span><button class="myPagetCategoryBtn">내 수강 목록</button></span>
			</div>
			<div class="myPagetCategory__element">
				<span><button class="myPagetCategoryBtn">포인트 내역</button></span>
			</div>
			<div class="myPagetCategory__element">
				<span><button class="myPagetCategoryBtn">회원정보변경</button></span>
			</div>
			<div class="myPagetCategory__element">
				<span><button class="myPagetCategoryBtn">장바구니</button></span>
			</div>
		</div>

		<div class="main_update">
			<div class="main_update_content_form">
				<!-- update form -->
				<form class="mainUpdateForm" class="main_update_content" name="frm">
					<input type="hidden" name="memberNo" value="${memberVo.memberNo}">
					<input type="hidden" name="memberId" value="${memberVo.memberId}">
					<input type="hidden" name="memberName"
						value="${memberVo.memberName}">


					<div class="main_update_content__item">
						<!-- 아이디 -->
						<div class="main_update_content_memberId">
							<label for="memberId">회원 ID</label>
							<div class="update_content_memberId--textBox">
								<a class="memberId">${memberVo.memberId}</a>
							</div>
						</div>


						<div class="main_update_content_memberNewPw">
							<label for="memberNewPw">새 비밀번호</label>
							<div class="update_content_memberNewPw--textBox">
								<input type="password" class="memberNewPw"
									placeholder="변경하실 비밀번호를 입력해주세요">
							</div>
							<div class="memberNewPwMessage"></div>
						</div>

						<!-- 이름 -->
						<div class="main_update_content_memberName">
							<label for="memberName">이름</label>
							<div class="update_content_memberName--textBox">
								<a class="memberId">${memberVo.memberName}</a>
							</div>
						</div>

						<div class="main_update_content_memberBirthDate">
							<label for="memberBirthDate">생년월일</label>
							<div class="update_content_memberBirthDate--textBox">								
								<p class="memberBirthDate">${memberVo.memberBirthDate}</p>
							</div>
						</div>
						
						<div class="main_update_content_memberGender">
							<label for="memberGender">성별</label>
							<div class="update_content_memberGender--textBox">
								<c:choose>
									<c:when test="${memberVo.memberGender == 1}">
										<a class="memberId">남자</a>
									</c:when>
									<c:otherwise>
										<a class="memberId">여자</a>
									</c:otherwise>
								</c:choose>
							</div>						
						</div>		
						
						<div class="main_update_content_memberPhoneNum">
							<label for="memberPhoneNum">휴대폰번호</label>
							<div class="update_content_memberPhoneNum--textBox">
								<p class="memberPhoneNum">${memberVo.memberPhoneNum}</p>
							</div>
						</div>
										

						<div class="main_update_content_memberAddress">
							<label for="memberAddress">주소</label>
							<div>
								<input type="text" id="memberZipCode" name="memberZipCode" placeholder="우편번호" readonly value="${memberVo.memberZipCode}">
								<input type="button" onclick="findAddress()" value="우편번호 찾기"><br>
								<input type="text" id="memberAddress" name="memberAddress" placeholder="주소" readonly value="${memberVo.memberAddress}"><br>
								<input type="text" id="memberAddressInfo" name=memberAddressInfo placeholder="상세주소" value="${memberVo.memberAddressInfo}">
							</div>
						</div>

						<div class="main_update_content_memberEMoney">
							<label for="memberEMoney">E-Money</label>
							<div class="update_content_memberEMoney--textBox">
								<a class="memberId">${memberVo.memberEMoney}</a>
							</div>
						</div>

						<div class="update_content_element--updateBtn">
							<input type="button" onclick="memberUpdateFnc()" value="수정하기" />
						</div>
					</div>
					<!-- main_update_content__item -->

				</form>
				<!-- update form -->

			</div>
			<!-- main_update_content_form -->



		</div>
		<!-- main_update -->

	</div>
	<!-- main-container -->

	<jsp:include page="/WEB-INF/views/Footer.jsp" />


</body>
</html>