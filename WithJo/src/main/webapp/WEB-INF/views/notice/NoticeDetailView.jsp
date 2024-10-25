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
<title>공지보기</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/notice/NoticeDetail.css">
<script>
    window.noticeNo = ${noticeVo.noticeNo};
</script>
<script src="/js/forum/notice/noticeDetail.js"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/Header.jsp"/> 
    
    <div id="noticeContainer">
        <div>
            <div>
                <c:if test="${memberVo.authority >= 1}">
                    <button type="button" onclick="pageMoveUpdate();" class="btn2">수정하기</button>
                    <button class="btn2" type="button" onclick="deleteFnc();">삭제</button>
                </c:if>
            </div>

            <div id="detailHeader">
                <p>${noticeVo.noticeTitle}
                    <span id="dateSpan"><fmt:formatDate value="${noticeVo.noticeCredate}" pattern="yyyy-MM-dd HH:mm" /></span>
                </p>
            </div>
            <div id="detailBody">
                <c:if test="${noticeVo.noticeImg ne null}">
                    <img alt="" src="/upload/${noticeVo.noticeImg}" id="noticeImg">
                </c:if>
                <div class="content" id="divnoticeContent">
                    
                </div>
            </div>
            
            <div>
	        	<button class="btn2" type="button" onclick="pageMoveList();">돌아가기</button>
	        </div>
        </div>
    </div>
    <form id="commonForm" name="commonForm">
        <input id="noticeNo" type="hidden" name="noticeNo" value="${noticeVo.noticeNo}">
    </form>
    <input type="hidden" id="noticeContent" name="noticeContent" value="${noticeVo.noticeContent}">
    <jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>