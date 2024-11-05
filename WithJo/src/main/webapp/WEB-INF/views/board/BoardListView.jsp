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
<title>게시판 목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="/css/common/common.css">
<script defer src="/js/common/common.js"></script>
<link rel="stylesheet" href="/css/forum/board/BoardList.css"> 
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
<script src="/js/forum/board/boardList.js"></script>

</head>

<body>

	<jsp:include page="/WEB-INF/views/Header.jsp"/> 
	
	<div id="mainContainer">
		<div id="boardContainer">
			<div class="topSearch">
				<div class="topSearchInner">
					<div class="topSearchTitle">
						<p class="boardTitleFont" ><span>게시판</span></p>
					</div>
					<div class="searchDiv">
						<select class="searchNField" name="searchNField" id="searchNField">
							<option value="all" <c:if test="${searchMap.searchField == 'all'}">selected</c:if>>전체</option>
							<option value="boardTitle" <c:if test="${searchMap.searchField == 'boardTitle'}">selected</c:if>>제목</option>
							<option value="boardContent" <c:if test="${searchMap.searchField == 'boardContent'}">selected</c:if>>내용</option>
						</select>
						
						<input class="searchInput" type="text" id="searchNKeyword" name="searchNKeyword" value="${searchMap.searchKeyword}">
						<button type="button" class="listButton" onclick="boardsearch();">검색</button>
					</div> <!-- searchDiv -->
				</div>
			</div>
		
			<div class="pageContentArea">
				<div class="pageContentAreaInner">
					<div class="categoryBox">
						<div class="forumKategorie">
							<div class="categorySelect">
								<span class="goNotice"><a href="/notice/list">공지사항</a></span>
							</div>
							<div class="categorySelect">
								<span class="goBoard"><a href="/board/list">게시판</a></span>
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
								<c:if test="${memberVo.authority >= 0}">
									<div class="boardAddButton" >
										<button onclick="pageMoveAdd();" class="listButton">게시글 등록</button>
									</div> <!-- boardAddButton -->
								</c:if>
								</div> <!-- contentDiv -->
						</div>
					</div> <!-- categoryBox -->
						<div class="boardTableBox">
							<c:forEach var="boardVo" items="${boardList}">
								<div class="boardTableBoxContent">
									<div class="tableTitleElement">
										<a href="/board/detail?boardNo=${boardVo.boardNo}&prevPage=${curPage}">${boardVo.boardTitle}</a>
									</div>
									<div class="tableNameElement">
										${boardVo.memberName}
									</div>	
									<div class="tableTimeElement">
										<fmt:formatDate value="${boardVo.boardCredate}" pattern="yyyy-MM-dd" />
									</div>
								</div>	
							</c:forEach>
						</div> <!-- boardTableBox -->
					
				
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
    </div>
    
    <jsp:include page="/WEB-INF/views/Footer.jsp"/>

</body>
</html>