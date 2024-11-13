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
<title>게시글추첨 목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/event/drawing/drawingList.css">
<script src="/js/event/drawing/drawingList.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="mainContainer">
	
		<div class="topSearch">
			<div class="topSearchInner">
				<div class="topSearchTitle">
					<p class="drawingTitleFont"><span>게시글추첨 이벤트</span></p>
				</div>
				<div class="searchDiv">
					<select class="searchNField" name="searchNField" id="searchNField">
						<option value="all" <c:if test="${searchMap.searchField == 'all'}">selected</c:if>>전체</option>
						<option value="drawingRound" <c:if test="${searchMap.searchField == 'drawingRound'}">selected</c:if>>회차</option>
						<option value="drawingSelNo" <c:if test="${searchMap.searchField == 'drawingMemberNo'}">selected</c:if>>당첨회원</option>
					</select>
					
					<input class="searchInput" type="text" id="searchNKeyword" name="searchNKeyword" value="${searchMap.searchKeyword}">
					<button type="button" class="listButton" onclick="drawingsearch();">검색</button>
				</div> <!-- searchDiv -->
			</div>
		</div>
	
		<div class="pageContentArea">
			<div class="pageContentAreaInner">
				<div class="categoryBox">				
					<div class="contentDiv">
						<div class="totalDiv">
							<p class="contentDivTotal">전체
								<span class="contentDivTotalBold">
									${pagingMap.totalCount}개
								</span>
							</p> 
						</div>
						<div class="contentDivInner">
							<c:if test="${memberVo.authority >= 1}">
								<div class="drawingAddButton" >
									<button onclick="pageMoveAdd();" class="listButton">게시글 추첨하기</button>
								</div> <!-- drawingAddButton -->
							</c:if>
						</div> <!-- contentDiv -->
					</div>	
				</div> <!-- categoryBox -->
					<div class="drawingTableBox">
						<c:forEach var="drawingVo" items="${drawingList}">
							<div class="drawingTableBoxContent">
								<div class="tableTitleElement">
									<a href="/drawing/detail?drawingNo=${drawingVo.drawingNo}&prevPage=${curPage}">${drawingVo.drawingRound} 회차</a>
								</div>
								<c:if test="${memberVo.authority >= 1}">
									<div class="tableTimeElement">
										${drawingVo.drawingMemberNo}
									</div>
									<div class="tableDateElement">
										${drawingVo.drawingMemberName}
									</div>
								</c:if>
								<div class="tableDateElement">
									${drawingVo.drawingStartDate} / ${drawingVo.drawingEndDate}
								</div>
								<c:if test="${memberVo.authority >= 1}">								
									<div class="tableTimeElement">
										<button class="btn2" type="button" onclick="deleteFnc(${drawingVo.drawingNo});">삭제</button>
									</div>
								</c:if>
							</div>	
						</c:forEach>
					</div> <!-- drawingTableBox -->
				
			
				<jsp:include page="/WEB-INF/views/common/Paging.jsp">
			        <jsp:param value="${pagingMap}" name="pagingMap" />
			    </jsp:include>
			
				<form id='pagingForm' action="./list" method="get">
					<input type="hidden" id='searchField' name="searchField" value="">
			      	<input type="hidden" id='searchKeyword' name="searchKeyword" value="">
			      	<input type="hidden" id='curPage' name="curPage"
			          value="${pagingMap.pagingVo.curPage}">
			    </form>
		    </div> <!-- pageContentAreaInner -->
    	</div><!-- pageContentArea -->
    </div>

<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>