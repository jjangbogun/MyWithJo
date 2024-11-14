<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추첨하기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<link rel="stylesheet" href="/css/event/drawing/drawingDetail.css">
<script defer src="/js/common/common.js"></script>
<script src="/js/event/drawing/drawingDetail.js"></script>
<script>
    var prevPage = ${prevPage != null ? prevPage : 1};
</script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/Header.jsp"/>

    <input type="hidden" id="drawingMembers" name="drawingMembers" value='${drawingVo.drawingMemberName}'>
	<input type="hidden" id="drawingMemberIds" name="drawingMemberIds" value='${drawingVo.drawingMemberId}'> 
    <div id="drawingContainer">
        <div>
        	<div class="btnDiv">
				<button class="btn2" type="button" onclick="pageMovedrawingList();">목록으로 가기</button>           
	    	</div>
            <div class="detailHeader">
                <p>${drawingVo.drawingRound} 회차
                    <span class="dateSpan">${drawingVo.drawingStartDate} / ${drawingVo.drawingEndDate}</span>
                </p>
            </div>
            <div class="detailBody">
                <div class="drawingMember" id="drawingMember">
                	<img class="eventImgs" alt="" src="/img/event/gifts.jpg" >
                	<div class="drawingNotice">
                		<div class="boardPeriod">
                			<p class="boardPeriodP">게시글 추첨 기간 : ${drawingVo.drawingStartDate} ~ ${drawingVo.drawingEndDate}</p>
                		</div>
                		<p>해당 기한내에 게시글을 작성하신분들중 </p>
                		<p>랜덤으로 ${drawingVo.drawingPersonnel}명에게 ${drawingVo.drawingPoint}포인트를 드립니다.</p>
                		<p>당첨되신분들 축하합니다!</p>
                	</div>
                	<div id="divMemberContainer">

                	</div>
                </div>
            </div>        

            <div class="reminderDiv">
                <ul>
                    <li>※본 이벤트의 기한은 변경될 수 있습니다.</li>
                </ul>
            </div>           

            <div class="btnDiv">
                <button class="btn2" type="button" onclick="pageMoveEventList();">돌아가기</button>             
            </div>      
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
<script type="text/javascript">
	divInMember();
</script>
</html>


