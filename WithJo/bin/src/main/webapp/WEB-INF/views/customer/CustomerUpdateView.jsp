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
<title>답변등록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/customer/CustomerAdd.css"> 
<script src="/js/forum/customer/customerUpdate.js"></script>

</head>

<body>

	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="customerAddContainer">
		<h1>답변 등록</h1>
		
		<form id="customerForm" action="update" method="post" onsubmit="customerCheckFnc(); return false;">
		<input type="hidden" id="customerAns" name="customerAns">
		<input type="hidden" id="customerNo" name="customerNo" value="${customerVo.customerNo}">
		<input type="hidden" id="memberANo" name="memberANo" value="${memberVo.memberNo}">
		<input type="hidden" id="customerCheck" name="customerCheck" value="답변완료">
		    
		    <div>
		        <label for="customerAns">답변 내용</label><br>
		        <textarea id="customerAns2" name="customerAns2" rows="5"></textarea><br>
		    </div>
		    
		    <div id="btnDiv">
		        <input class="customerBtn3" type="submit" value="등록">
		        <input class="customerBtn3" type="reset" value="취소">
				<input class="customerBtn3" type="button" value="뒤로가기" onclick="history.back();">
		    </div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>