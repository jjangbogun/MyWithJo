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
<title>로또목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/event/lotto/lottoList.css">
<script src="/js/event/lotto/lottoList.js"></script>
<script type="text/javascript">

	function deleteFnc(lottoNo}) {        
	    if(confirm("해당 공지를 삭제 하시겠습니까?")) {	    	
	        $.ajax({
	        	url: '/lotto/delete',
	        	type: 'POST'
	        	data: { lottoNo: lottoNo },
	        	success: function(result) {
					alert("삭제되었습니다");
					location.reload();
				}
	        });        
		}
	}
</script>
</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="mainContainer">
	
		<div class="topSearch">
			<div class="topSearchInner">
				<div class="topSearchTitle">
					<p class="lottoTitleFont"><span>추첨번호관리</span></p>
				</div>
				<div class="searchDiv">
					<select class="searchNField" name="searchNField" id="searchNField">
						<option value="all" <c:if test="${searchMap.searchField == 'all'}">selected</c:if>>전체</option>
						<option value="lottoRound" <c:if test="${searchMap.searchField == 'lottoRound'}">selected</c:if>>회차</option>
						<option value="lottoSelNo" <c:if test="${searchMap.searchField == 'lottoSelNo'}">selected</c:if>>당첨번호</option>
					</select>
					
					<input class="searchInput" type="text" id="searchNKeyword" name="searchNKeyword" value="${searchMap.searchKeyword}">
					<button type="button" class="listButton" onclick="lottosearch();">검색</button>
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
							<div class="lottoAddButton" >
								<button onclick="pageMoveAdd();" class="listButton">로또 등록</button>
							</div> <!-- lottoAddButton -->
						</div> <!-- contentDiv -->
					</div>	
				</div> <!-- categoryBox -->
					<div class="lottoTableBox">
						<c:forEach var="lottoVo" items="${lottoList}">
							<div class="lottoTableBoxContent">
								<div class="tableTitleElement">
									<a href="/lotto/detail?lottoNo=${lottoVo.lottoNo}">${lottoVo.lottoRound} 회차</a>
								</div>
								<div class="tableTimeElement">
									${lottoVo.lottoSelNo}
								</div>
								<div class="tableDateElement">
									${lottoVo.lottoStartDate} - ${lottoVo.lottoEndDate}
								</div>
								<div class="tableTimeElement">
									<fmt:formatDate value="${lottoVo.lottoCredate}" pattern="yyyy-MM-dd" />
								</div>
								
								<div class="tableTimeElement">
									<button class="btn2" type="button" onclick="deleteFnc(${lottoVo.lottoNo});">삭제</button>
								</div>
							</div>	
						</c:forEach>
					</div> <!-- lottoTableBox -->
				
			
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