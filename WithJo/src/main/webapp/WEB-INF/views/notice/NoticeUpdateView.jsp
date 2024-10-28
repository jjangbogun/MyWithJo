<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<meta charset="UTF-8">
<title>공지 수정</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/notice/NoticeAdd.css"> 
<script src="/js/forum/notice/noticeUpdate.js"></script>
<script type="text/javascript">

</script>
</head>

<body>

	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="noticeAddContainer">
		<h1>게시글 등록</h1>
		
		<form id="noticeForm" action="update" method="post" enctype="multipart/form-data" onsubmit="noticeCheck(); return false;">
		<input type="hidden" id="noticeContent" name="noticeContent">
		<input type="hidden" id="noticeNo" name="noticeNo" value="${noticeVo.noticeNo}">
		<input type="hidden" id="noticeImgName" name="noticeImgName" value="${noticeVo.noticeImg}">
		<input type="hidden" id="noticeImgDelete" name="noticeImgDelete" value="0">
		    
		    <div>
		        <label for="noticeTitle">게시글 제목</label><br>
		        <input type="text" id="noticeTitle" name="noticeTitle" value="${noticeVo.noticeTitle}"><br>
		    </div>
		    
		    <div>
		        <label for="noticeContent">게시글 내용</label><br>
		        <textarea id="noticeContent2" name="noticeContent2" rows="5">${noticeVo.noticeContent}</textarea><br>
		    </div>
		    
		    <div>
		        <label for="noticeImg">게시글 이미지</label><br>
		        <c:if test="${noticeVo.noticeImg ne null}">
					<img alt="" src="/upload/${noticeVo.noticeImg}" id="noticeImg">
				    <button type='button' onclick="imgDelete();">이미지 삭제</button>
	            </c:if>
		        <input type="file" id="noticeImg" name="noticeImg"><br>
		    </div>
		    
		    <div id="btnDiv">
		        <input class="noticeBtn3" type="submit" value="수정">
		        <input class="noticeBtn3" type="reset" value="취소">
				<input class="noticeBtn3" type="button" value="뒤로가기" onclick="history.back();">
		    </div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>