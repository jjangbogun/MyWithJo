<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
<!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/member/memberAdd.css">
<script defer src="/js/common/common.js"></script>
<script defer src="/js/member/memberAdd.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


</head>
<body>

	<jsp:include page="/WEB-INF/views/Header.jsp"/>


	<div id="main-container">
	
		<div class="signUpFlexBox">
			<div class="signUpImg">
				<img class="signUpImg__img" alt="." src="/img/common/yoga_login_img.jpg">
				<div class="signUpImg__textContainer">
					<div class="signUpImg__firstText">
						<p class="signInImg__firstText--text"><span>위드조 문화센터에</span></p>
					</div>
					<div class="signUpImg__secondText">
						<p class="signInImg__secondText--text"><span>처음 오셨나요?</span></p>
					</div>
					<div class="signUp_content--signupBtn">
						<button type="button" class="signUp_btn" onclick="location.href='/member/add'">가입하러가기 -></button>
					</div>
				</div>
			</div>
			

		<div class="main-container_signUp">
			<div class="main-container_signUp--title">
				<p class="main-container_signUp--title--text">회 원 가 입</p>							
			</div>
			<div class="main-container_signUp_content_form">
				<!-- signup form -->
				 <form id="signUpForm">

					<div class="main_signUp_content__memberId">
						<!-- 아이디 -->
						<span><label for="memberId" class="label__memberId">아이디</label></span>						
						<span><input id="memberId" class="memberId" type="text"  placeholder="영어 + 숫자" name="memberId"></span>		
						<span><input type="button" class="checkIdBtn" value="중복 체크"></span>		
					</div>


					<!-- 패스워드 -->
					<div class="main_signUp_content__memberPw">
						<span><label for="memberPw" class="label__memberPw">패스워드</label></span>
						<span><input id="memberPw" class="memberPw" type="password" placeholder="영어 + 숫자 4 자 이상" name="memberPw"></span>
						<div class="passwordMessage"></div>
					</div>


					<!-- 이름 -->
					<div class="main_signUp_content__memberName">
						<span><label for="memberName" class="label__memberName">이름</label></span>
						<span><input id="memberName" class="memberName" type="text" placeholder="이름"  name="memberName"></span>
					</div>


					<div class="main_signUp_content__memberBirthDate">
						<span><label for="memberBirthDate" class="label__memberBirthDate">생년월일</label></span>
						<span><input type="text" id="birthDateYear" class="birthDateYear" name="birthDateYear" maxlength="4" max="2019" min="1924" placeholder="YYYY"></span>
						<span><input type="text" id="birthDateMonth" class="birthDateMonth" name="birthDateMonth" maxlength="2"  max="12" min="01" placeholder="MM"></span>
						<span><input type="text" id="birthDateDay" class="birthDateDay" name="birthDateDay" maxlength="2"  max="31" min="01" placeholder="DD"></span>						
						
						<div class="birthDateYearMessage"></div>
						<div class="birthDateMonthMessage"></div>
						<div class="birthDateDayMessage"></div>
					</div>
					
					<div class="main_signUp_content__memberGender">
  						<span><label for="memberGender" class="label__memberGender">성별</label></span>
  						<span><input type="radio" id="genderMale" name="memberGender" value="1"></span>
  						<span><label for="genderMale" class="genderMale">남성</label></span>
  						<span><input type="radio" id="genderFemale" name="memberGender" value="2"></span>
  						<span><label for="genderFemale" class="genderFemale">여성</label></span>  			
					</div>

					<div class="main_signUp_content__memberAddress">
						<span><label for="memberAddress" class="label__memberAddress">주소</label></span>
						<span><input type="text" id="memberZipCode" class="memberZipCode" name="memberZipCode" placeholder="우편번호" readonly ></span>
						<span><input type="button" class="ZipCodeFindBtn" onclick="findAddress()" value="우편번호 찾기"></span><br>						
						<span><input type="text" id="memberAddress" class="memberAddress" name="memberAddress" placeholder="주소" readonly></span><br>						
						<span><input type="text" id="memberAddressInfo" class="memberAddressInfo" name=memberAddressInfo placeholder="상세주소"></span>				
					</div>

					<div class="signUpBtn">
						<input type="button" class="signUpBtn" onclick="signUpFnc()" value="회원가입" />
					</div>

				</form>

				</div>
			</div>
		</div>
	</div>

	

	<jsp:include page="/WEB-INF/views/Footer.jsp"/>

  
</body>
</html>