<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>게시판 상세</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/board/BoardDetail.css">
<script>
    window.boardNo = ${boardVo.boardNo};
    window.currentMemberNo = ${memberVo.memberNo};
    window.currentUserAuthority = ${memberVo.authority};
</script>
<script src="/js/forum/board/boardDetail.js"></script>
<script>
    var prevPage = ${prevPage != null ? prevPage : 1};
</script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/Header.jsp"/> 
    
	<div id="boardContainer">
	    <div>

			<div class="detailHeader">
			    <p>${boardVo.boardTitle}</p>
			    <div class="nameSpan">${boardVo.memberName}</div>
			    <div class="dateSpan">
			        <fmt:formatDate value="${boardVo.boardCredate}" pattern="yyyy-MM-dd HH:mm" />
			    </div>
			</div>
	        <div class="detailBody">
	            <c:if test="${boardVo.boardImg ne null}">
					<img alt="" src="/upload/${boardVo.boardImg}" id="boardImg" class="detailImg">
	            </c:if>
	            <div class="contentBox" id="divBoardContent">
	                
	            </div>
	        </div>
	        
	        <div class="btnDiv">
	    		<c:if test="${boardVo.memberNo eq memberVo.memberNo}">
	    			<button onclick="pageMoveUpdate();" class="btn2">게시글 수정</button>
	    		</c:if>
	    		<c:if test="${boardVo.memberNo eq memberVo.memberNo or memberVo.authority >= 1}">
					<button class="btn2" type="button" onclick="deleteFnc();">삭제</button>
	            </c:if>	            
	            <button class="btn2" type="button" onclick="pageMoveList();">돌아가기</button>
	    	</div>
	    	
	        <div class="commentsBody">
    			
    			<c:choose>
				    <c:when test="${memberVo.memberNo >= 0}">
					    <div class="commentsHeader">
			            	<p>댓글 쓰기</p>
			        	</div>
			        	<form action="/comments/add" method="post">
			        		<input type="hidden" id="memberNo" name="memberNo" value="${memberVo.memberNo}">
			        		<input type="hidden" id="boardNo" name="boardNo" value="${boardVo.boardNo}">
			        		<div class="reminderDiv">
				        		<ul>
					   				<li>광고, 욕설, 악의적 비방, 허위사실 기재 등의 내용 등록 시 관리자에 의해 삭제 될 수 있습니다.</li>
					   				<li>회원님의 소중한 개인정보 보호를 위하여 별도 연락처 등의 기재를 삼가해주시기 바랍니다.</li>
					   			</ul>
				   			</div>
				   			<div style="display: flex; align-items: stretch;">
			        			<textarea id="commentsContent" name="commentsContent" rows="5"></textarea>
			       				 <button id="contentSubmit">작성</button> 
			    			</div>
		    			</form>
				    </c:when>
				    <c:otherwise>
					    <div class="reminderDiv">
			        		<ul>
				   				<li>댓글작성은 로그인이 필요합니다.</li>
				   			</ul>
			   			</div>
				    </c:otherwise>
				</c:choose>
	        	<div class="commentsHeader">
	            	<p>댓글</p>
	        	</div>
	        	<div id="commentsList" class="commentsList">
	        	
	        	</div>

	        </div>

	    </div>
	</div>
	<form id="commonForm" name="commonForm">
		<input id="boardNo" type="hidden" name="boardNo" value="${boardVo.boardNo}">
	</form>
	<input type="hidden" id="boardContent" name="boardContent" value="${boardVo.boardContent}">
    <jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>