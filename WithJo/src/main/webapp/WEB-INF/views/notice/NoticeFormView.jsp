<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<meta charset="UTF-8">
<title>공지 등록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/notice/noticeAdd.css">
<script src="/js/forum/notice/noticeForm.js"></script>
</head>

<body>
	
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="noticeAddContainer">
		<h1>공지 등록</h1>
		
		<form id="noticeForm" action="add" method="post" enctype="multipart/form-data" onsubmit="noticeCheck(); return false;">
		<input type="hidden" id="noticeContent" name="noticeContent">
		<input type="hidden" id="memberNo" name="memberNo" value="${memberVo.memberNo}">
		    
		    <div>
		        <label for="noticeTitle">공지 제목</label><br>
		        <input type="text" id="noticeTitle" name="noticeTitle"><br>
		    </div>
		    
		    <div>
		        <label for="noticeContent">공지 내용</label><br>
		        <textarea id="noticeContent2" name="noticeContent2" rows="5"></textarea><br>
		    </div>
		    
		    <div>
		        <label for="noticeImg">공지 이미지</label><br>
		        <input type="file" id="noticeImg" name="noticeImg"><br>
		    </div>
		    
		    <div id="btnDiv">
		        <input class="noticeBtn3" type="submit" value="등록">
		        <input class="noticeBtn3" type="reset" value="취소">
				<input class="noticeBtn3" type="button" value="뒤로가기" onclick="pageMoveList();">
		    </div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>