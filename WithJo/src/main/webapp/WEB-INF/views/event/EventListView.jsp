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
<script type="text/javascript">
	function lottoHide() {
		var hideData = {
	        eventLotto: 0, // 배열을 JSON 문자열로 변환
		};
		
	    $.ajax({
	        url: '/event/update',
	        method: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(hideData),
	        success: function (data) {
	            console.log('처리 성공:', data);
	        },
	        error: function(xhr, status, error) {
	            console.error('Error:', error);
	            alert('처리 실패: ' + status + ' - ' + error);
	        }
	    });
	}
	
	function drawingHide() {
		var hideData = {
	        eventDrawing: 0, // 배열을 JSON 문자열로 변환
		};
		
	    $.ajax({
	        url: '/event/update',
	        method: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(hideData),
	        success: function (data) {
	            console.log('처리 성공:', data);
	        },
	        error: function(xhr, status, error) {
	            console.error('Error:', error);
	            alert('처리 실패: ' + status + ' - ' + error);
	        }
	    });
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	<input type="hidden" name="lottoVal" id="lottoVal" value="${eventVo.eventLotto}">
	<input type="hidden" name="drawingVal" id="drawingVal" value="${eventVo.eventDrawing}">
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
					<c:forEach var="eventVo" items="${eventList}">
						<c:if test="${eventVo.eventLotto == 1}">
							<div id="lottoDiv">
								<div class="eventTableBoxContent">
									<div class="tableTitleElement">
										<a class="imgTag" href="/lotto/detail">
											<img class="eventImgs" alt="" src="/img/event/lottoEvent.jpg" style="width: 350px;">
										</a>
										<a class="textTag" href="/lotto/detail">주간 로또 하러가기</a>
										<div class="tableTimeElement">
											별도공지 까지
											<c:if test="${memberVo.authority >= 1}">
												<button onclick="lottoHide();" class="eventBtn">로또이벤트 숨기기</button>
											</c:if>		           					 
										</div>
									</div>
								</div>
							</div>
						</c:if>	
						<c:if test="${eventVo.eventDrawing == 1}">
							<div id="drawingDiv">
								<div class="eventTableBoxContent">
									<div class="tableTitleElement">
										<a class="imgTag" href="/drawing/detail">
											<img class="eventImgs" alt="" src="/img/event/drawingEvent.jpg" style="width: 350px;">
										</a>
										<a class="textTag" href="/drawing/detail">게시판 이벤트 확인하기</a>
										<div class="tableTimeElement">
											별도공지 까지
											<c:if test="${memberVo.authority >= 1}">
												<button onclick="drawingHide();" class="eventBtn">추첨이벤트 숨기기</button>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>	
				</div> <!-- eventTableBox -->			
		    </div> <!-- pageContentAreaInner -->
    	</div><!-- pageContentArea -->
    </div>

<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>