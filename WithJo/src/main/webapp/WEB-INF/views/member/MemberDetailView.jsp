<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link rel="stylesheet" href="/css/member/memberDetail.css">
<script defer src="/js/common/common.js"></script>
<script defer src="/js/member/memberDetail.js"></script>
<script>
var userAuthority = ${sessionScope.memberVo.authority};
var memberNo = ${memberVo.memberNo};
var reserveList = ${reserveList};
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
								<p class="memberId">${memberVo.memberNo}</p>
							</div>
						</div>


						<!-- 아이디 -->
						<div class="memberDetail_update_content_memberId">
							<label for="memberId">회원 ID</label>
							<div class="update_content_memberId--textBox">
								<p class="memberId">${memberVo.memberId}</p>
							</div>
						</div>


						<!-- 이름 -->
						<div class="memberDetail_update_content_memberName">
							<label for="memberName">이름</label>
							<div class="update_content_memberName--textBox">
								<p class="memberId">${memberVo.memberName}</p>
							</div>
						</div>

						<div class="memberDetail_update_content_memberBirthDate">
							<label for="memberBirthDate">생년월일</label>
							<div class="update_content_memberBirthDate--textBox">
								<p class="memberBirthDate">${memberVo.memberBirthDate}</p>								
							</div>
						</div>

						<div class="memberDetail_update_content_memberGender">
							<label for="memberGender">성별</label>
							<div class="update_content_memberGender--textBox">
								<c:choose>
									<c:when test="${memberVo.memberGender == 1}">
										<p class="memberId">남자</p>
									</c:when>
									<c:otherwise>
										<p class="memberId">여자</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						
						
						
						<div class="memberDetail_update_content_memberPhoneNum">
							<label for="memberPhoneNum">휴대폰번호</label>
							<div class="update_content_memberPhoneNum--textBox">
								<p class="memberPhoneNum">${memberVo.memberPhoneNum}</p>
							</div>
						</div>
						<div class="memberDetail_update_content_memberEMoney">
							<label for="memberEMoney">E-Money</label>
							<div class="update_content_memberEMoney--textBox">
								<p id="memberEMoney">${memberVo.memberEMoney}</p>
							</div>
						</div>

						<div class="memberDetail_update_content_memberAddress">
							<label for="memberAddress">주소</label>
							<div>
								<input type="text" id="memberZipCode" name="memberZipCode" placeholder="우편번호" readonly value="${memberVo.memberZipCode}">
								<input type="button" onclick="findAddress()" value="우편번호 찾기"><br>
								<input type="text" id="memberAddress" name="memberAddress" placeholder="주소" readonly value="${memberVo.memberAddress}"><br>
								<input type="text" id="memberAddressInfo" name=memberAddressInfo placeholder="상세주소" value="${memberVo.memberAddressInfo}">								
							</div>
						</div>

						
						
						<div class="memberDetial_updat_content_reserveList">
							   <label for="memberReserveList">수강목록</label>
							   
				                    

						        <!-- 수강 목록 반복 -->
							        <c:if test="${not empty reserveList}">
										<div id="courseContainer" class="myReserveList-item" data-course='${fn:replace(reserveList, "\'", "\\\'")}'></div>
						 	       </c:if>
							
							        <!-- 수강 목록이 비어 있을 때 메시지 출력 -->
							        <c:if test="${empty reserveList}">
							            <p>현재 수강 중인 강의가 없습니다.</p>
							        </c:if>
							    </div>
							</div>

						<div class="memberDetail_update_content_authority">
 						    <label for="authority">권한</label>
    						<div class="update_content_authority--textBox">
      							  <input type="radio" id="authority0" name="authority" value="0" 
            						   ${memberVo.authority == 0 ? 'checked' : ''} 
           							   ${memberVo.authority == 1 ? 'disabled' : ''}> 
       							  <label for="authority0">일반 사용자</label> 
      							  <input type="radio" id="authority1" name="authority" value="1" 
             						   ${memberVo.authority == 1 ? 'checked' : ''}>
       							  <label for="authority1">관리자</label>
   							</div>
						</div>





						<div class="update_content_element--updateBtn">
							<input type="button" onclick="detailUpdateFnc()" value="수정하기" /> 
							<input type="button" value="뒤로가기" onclick="goBack()" />
						</div>
						
						</form>
					</div>
					<!-- memberDetail_update_content__item -->

				
				<!-- update form -->

			</div>
			<!-- memberDetail_update_content_form -->



		</div>
		<!-- memberDetail_update -->

	
	<!-- memberDetail-container -->


	<jsp:include page="/WEB-INF/views/Footer.jsp" />

</body>
</html>