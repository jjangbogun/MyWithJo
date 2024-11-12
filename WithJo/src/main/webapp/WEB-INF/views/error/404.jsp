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
<title>404 오류</title>
<!-- css 초기화 -->
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
  rel="stylesheet">
<!-- 페이지 css -->
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/error/errorPages.css"> 
<script defer src="/js/common/common.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	<div id="mainContainer">
		<div class="errorContents">
			<div>
				<img class="eventImgs" alt="404 Error" src="/img/error/errorImg.png" />
			</div>
			<div class="errorTitle">페이지를 찾을 수 없습니다.</div>
			<div class="errorComment">페이지를 찾을 수 없거나 준비중입니다. 관리자에게 문의해주세요.</div>
			<button onclick="window.location.href='/'" class="backButton">메인으로 돌아가기</button>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>
