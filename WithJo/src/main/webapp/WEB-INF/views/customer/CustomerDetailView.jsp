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
<title>고객센터</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/customer/CustomerDetail.css">
<script>
    window.customerNo = ${customerVo.customerNo};
</script>
<script src="/js/forum/customer/customerDetail.js"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/Header.jsp"/> 
    
    <div id="customerContainer">
        <div>


            <div class="detailHeader">
                <p>${customerVo.customerTitle}
                    <span class="dateSpan"><fmt:formatDate value="${customerVo.customerQCredate}" pattern="yyyy-MM-dd HH:mm" /></span>
                </p>
            </div>
            <div class="detailBody">
                <div class="content" id="divcustomerQue">
                    
                </div>
                
                <c:if test="${customerVo.customerAns ne null}">
                    <div class="ansHeader">
                        <p>답변
                            <span class="dateSpan"><fmt:formatDate value="${customerVo.customerACredate}" pattern="yyyy-MM-dd HH:mm" /></span>
                        </p>
                    </div>
                    
                    <div class="content" id="divcustomerAns">
                    
                    </div>
                </c:if>
            </div>
            
            <div class="btnDiv">       
                <c:if test="${memberVo.authority >= 1}">
                    <button type="button" onclick="pageMoveAnswer();" class="btn2">답변하기</button>
                </c:if>                        
                <c:if test="${customerVo.memberQNo eq memberVo.memberNo or memberVo.authority >= 1}">
                    <button class="btn2" type="button" onclick="deleteFnc();">삭제</button>
                </c:if>
                <button class="btn2" type="button" onclick="pageMoveList();">돌아가기</button>
	        </div>
            
        </div>
    </div>
    <form id="commonForm" name="commonForm">
        <input type="hidden" name="customerNo" value="${customerVo.customerNo}">
    </form>
    <input type="hidden" id="customerQue" name="customerQue" value="${customerVo.customerQue}">
    <input type="hidden" id="customerAns" name="customerAns" value="${customerVo.customerAns}">
    <jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>