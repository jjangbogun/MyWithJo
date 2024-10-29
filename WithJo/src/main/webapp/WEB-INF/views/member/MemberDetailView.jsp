<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>회원 상세</title>
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
<link rel="stylesheet" href="/css/member/memberList.css">
<script defer src="/js/common/common.js"></script>
<script defer src="/js/member/memberDetail.js"></script>
<script>
var userAuthority = ${sessionScope.memberVo.authority};
</script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
.memberDetail-container {
	margin-top: 150px;
}
</style>
</head>


<body>

	<jsp:include page="/WEB-INF/views/Header.jsp" />

	<div class="memberDetail-container">

		<div class="memberDetail_update">
			<div class="memberDetail_update_content_form">
				<!-- update form -->
				<form class="memberDetailUpdateForm" class="main_update_content" name="frm">
					<input type="hidden" name="memberNo" value="${memberVo.memberNo}">




					<div class="memberDetail_update_content__item">

						<div class="memberDetail_update_content_memberNo">
							<label for="memberNo">회원 No</label>
							<div class="update_content_memberNo--textBox">
								<a class="memberId">${memberVo.memberNo}</a>
							</div>
						</div>


						<!-- 아이디 -->
						<div class="memberDetail_update_content_memberId">
							<label for="memberId">회원 ID</label>
							<div class="update_content_memberId--textBox">
								<a class="memberId">${memberVo.memberId}</a>
							</div>
						</div>


						<!-- 이름 -->
						<div class="memberDetail_update_content_memberName">
							<label for="memberName">이름</label>
							<div class="update_content_memberName--textBox">
								<a class="memberId">${memberVo.memberName}</a>
							</div>
						</div>

						<div class="memberDetail_update_content_memberBirthDate">
							<label for="memberBirthDate">생년월일</label>
							<div class="update_content_memberBirthDate--textBox">
								<fmt:parseDate value="${memberVo.memberBirthDate}" pattern="yyyy-MM-dd HH:mm:ss" var="parsedDate" />
								<fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd" var="formattedDate" />
								<a class="memberId">${formattedDate}</a>
							</div>
						</div>

						<div class="memberDetail_update_content_memberGender">
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

						<div class="memberDetail_update_content_memberAddress">
							<label for="memberAddress">주소</label>
							<div>
								<input type="text" id="memberZipCode" name="memberZipCode" placeholder="우편번호" readonly value="${memberVo.memberZipCode}">
								<input type="button" onclick="findAddress()" value="우편번호 찾기"><br>
								<input type="text" id="memberAddress" name="memberAddress" placeholder="주소" readonly value="${memberVo.memberAddress}"><br>
								<input type="text" id="memberAddressInfo" name=memberAddressInfo placeholder="상세주소" value="${memberVo.memberAddressInfo}">
								<input type="text" id="sample6_extraAddress" placeholder="참고항목" disabled>
							</div>
						</div>

						<div class="memberDetail_update_content_memberEMoney">
							<label for="memberEMoney">E-Money</label>
							<div class="update_content_memberEMoney--textBox">
								<a class="memberId">${memberVo.memberEMoney}</a>
							</div>
						</div>

						<div class="memberDetail_update_content_authority">
							<label for="authority">권한</label>
							<div class="update_content_authority--textBox">
								<input type="radio" id="authority0" name="authority" value="0" ${memberVo.authority == 0 ? 'checked' : ''}> 
								<label for="authority0">일반 사용자</label> 
								<input type="radio"	id="authority1" name="authority" value="1" ${memberVo.authority == 1 ? 'checked' : ''}>
								<label for="authority1">관리자</label>
							</div>
						</div>





						<div class="update_content_element--updateBtn">
							<input type="button" onclick="detailUpdateFnc()" value="수정하기" /> 
							<input type="button" value="뒤로가기" onclick="goBack()" />
						</div>
					</div>
					<!-- memberDetail_update_content__item -->

				</form>
				<!-- update form -->

			</div>
			<!-- memberDetail_update_content_form -->



		</div>
		<!-- memberDetail_update -->

	</div>
	<!-- memberDetail-container -->


	<jsp:include page="/WEB-INF/views/Footer.jsp" />

</body>
</html>