<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<meta charset="UTF-8">
<title>질문 등록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/customer/customerAdd.css"> 
<script src="/js/forum/customer/customerForm.js"></script>

</head>

<body>
	
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="customerAddContainer">
		<h1>공지 등록</h1>
		
		<form id="customerForm" action="add" method="post" enctype="multipart/form-data" onsubmit="customerCheck(); return false;">
		<input type="hidden" id="customerQue" name="customerQue">
		<input type="hidden" id="memberQNo" name="memberQNo" value="${memberVo.memberNo}">
		    
		    <div>
		        <label for="customerTitle">질문제목</label><br>
		        <input type="text" id="customerTitle" name="customerTitle"><br>
		    </div>
		    
		    <div>
		        <label for="customerQue">질문내용</label><br>
		        <textarea id="customerQue2" name="customerQue2" rows="5"></textarea><br>
		    </div>
		    
		    <div id="btnDiv">
		        <input class="customerBtn3" type="submit" value="등록">
		        <input class="customerBtn3" type="reset" value="취소">
				<input class="customerBtn3" type="button" value="뒤로가기" onclick="pageMoveList();">
		    </div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>