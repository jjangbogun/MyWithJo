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
<title>고객센터</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/customer/customerList.css">
<script src="/js/forum/customer/customerList.js"></script>

</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="mainContainer">
	
		<div class="topSearch">
			<div class="topSearchInner">
				<div class="topSearchTitle">
					<p class="customerTitleFont" ><span>고객센터</span></p>
				</div>
				<div class="searchDiv">
					<select class="searchNField" name="searchNField" id="searchNField">
						<option value="all" <c:if test="${searchMap.searchField == 'all'}">selected</c:if>>제목 + 내용</option>
						<option value="customerTitle" <c:if test="${searchMap.searchField == 'customerTitle'}">selected</c:if>>제목</option>
						<option value="customerQue" <c:if test="${searchMap.searchField == 'customerQue'}">selected</c:if>>내용</option>
					</select>
					
					<input class="searchInput" type="text" id="searchNKeyword" name="searchNKeyword" value="${searchMap.searchKeyword}">
					<button type="button" class="listButton" onclick="customersearch();">검색</button>
				</div> <!-- searchDiv -->
			</div>
		</div>
	
		<div class="pageContentArea">
			<div class="pageContentAreaInner">
				<div class="categoryBox">
					<div class="forumKategorie">
						<div class="categorySelect">
							<span class="gocustomer"><a href="/notice/list">공지사항</a></span>
						</div>
						<div class="categorySelect">
							<span class="gocustomer"><a href="/board/list">게시판</a></span>
						</div>
						<div class="categorySelect">
							<span class="goCustomer"><a href="/customer/list">고객센터</a></span>
						</div>
					</div> <!-- forumKategorie -->
					
					<div class="contentDiv">
						<div class="totalDiv">
							<p class="contentDivTotal">전체
								<span class="contentDivTotalBold">
									${pagingMap.totalCount}개
								</span>
							</p> 
						</div>
						<div class="contentDivInner">
							<c:if test="${memberVo.authority == 0}">
								<div class="customerAddButton" >
									<button onclick="pageMoveAdd();" class="listButton">질문하기</button>
								</div> <!-- customerAddButton -->
							</c:if>
						</div> <!-- contentDiv -->
					</div>
				</div> <!-- categoryBox -->
					<div class="customerTableBox">
						<c:forEach var="customerVo" items="${customerList}">
							<c:choose>
								<c:when test="${customerVo.memberQNo == memberVo.memberNo || memberVo.authority >= 1}">
									<div class="customerTableBoxContent">
										<div class="tableTitleElement">
											<a href="/customer/detail?customerNo=${customerVo.customerNo}">${customerVo.customerTitle}</a>
										</div>
										<div class="tableNameElement">
											${customerVo.memberName}
										</div>															
										<div class="tableCheckElement">
											${customerVo.customerCheck}
										</div>
										<div class="tableTimeElement">
											<fmt:formatDate value="${customerVo.customerQCredate}" pattern="yyyy-MM-dd" />
										</div>
									</div>
								</c:when>
							    <c:otherwise>
									<div class="customerTableBoxContent">
										<div class="tableTitleElement">
											다른 회원님의 질문입니다.
										</div>
										<div class="tableNameElement">
										</div>															
										<div class="tableCheckElement">
											${customerVo.customerCheck}
										</div>
										<div class="tableTimeElement">
											<fmt:formatDate value="${customerVo.customerQCredate}" pattern="yyyy-MM-dd" />
										</div>
									</div>
	   							</c:otherwise>
   							</c:choose>
						</c:forEach>
					</div> <!-- customerTableBox -->
				
			
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