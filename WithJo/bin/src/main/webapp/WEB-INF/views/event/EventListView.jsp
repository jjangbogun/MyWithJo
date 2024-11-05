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
<title>이벤트목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/event/EventList.css">
<script src="/js/event/eventList.js"></script>

</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="mainContainer">
	
		<div class="topSearch">
			<div class="topSearchInner">
				<div class="topSearchTitle">
					<p class="eventTitleFont" ><span>이벤트</span></p>
				</div>
			</div>
		</div>
	
		<div class="pageContentArea">
			<div class="pageContentAreaInner">
				<div class="eventTableBox">
					<div class="eventTableBoxContent">
						<div class="tableTitleElement">
							<a class="imgTag" href="/lotto/detail">
								<img class="eventImgs" alt="" src="/img/event/lottoEvent.jpg" style="width: 350px;">
							</a>
							<a class="textTag" href="/lotto/detail">주간 로또 하러가기</a>
							<div class="tableTimeElement">
								별도공지 까지
							</div>
						</div>
					</div>
					<div class="eventTableBoxContent">
						<div class="tableTitleElement">
							<a class="imgTag" href="/lotto/detail">
								<img class="eventImgs" alt="" src="/img/event/drawingEvent.jpg" style="width: 350px;">
							</a>
							<a class="textTag" href="/drawing/list">게시판 이벤트 확인하기</a>
							<div class="tableTimeElement">
								별도공지 까지
							</div>
						</div>
					</div>
				</div> <!-- eventTableBox -->			
		    </div> <!-- pageContentAreaInner -->
    	</div><!-- pageContentArea -->
    </div>

<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>