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
<title>게시글 수정</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/board/BoardAdd.css"> 
<script src="/js/forum/board/boarUpdate.js"></script>
</head>

<body>

	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="boardAddContainer">
		<h1>게시글 등록</h1>
		
		<form id="boardForm" action="update" method="post" enctype="multipart/form-data" onsubmit="boardCheck(); return false;">
		<input type="hidden" id="boardContent" name="boardContent">
		<input type="hidden" id="boardNo" name="boardNo" value="${boardVo.boardNo}">
		<input type="hidden" id="boardImgName" name="boardImgName" value="${boardVo.boardImg}">
		<input type="hidden" id="boardImgDelete" name="boardImgDelete" value="0">
		    
		    <div>
		        <label for="boardTitle">게시글 제목</label><br>
		        <input type="text" id="boardTitle" name="boardTitle" value="${boardVo.boardTitle}"><br>
		    </div>
		    
		    <div>
		        <label for="boardContent">게시글 내용</label><br>
		        <textarea id="boardContent2" name="boardContent2" rows="5">${boardVo.boardContent}</textarea><br>
		    </div>
		    
		    <div>
		        <label for="boardImg">게시글 이미지</label><br>
		        <c:if test="${boardVo.boardImg ne null}">
					<img alt="" src="/upload/${boardVo.boardImg}" id="boardImg">
					<button type='button' onclick="imgDelete();">이미지 삭제</button>
	            </c:if>
		        <input type="file" id="boardImg" name="boardImg"><br>
		    </div>
		    
		    <div id="btnDiv">
		        <input class="boardBtn3" type="submit" value="수정">
		        <input class="boardBtn3" type="reset" value="취소">
				<input class="boardBtn3" type="button" value="뒤로가기" onclick="history.back();">
		    </div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>