function boardsearch() {
	var searchNField = $("#searchNField").val();
	var searchNKeyword = $("#searchNKeyword").val();
	
	$("#searchField").val(searchNField);
	$("#searchKeyword").val(searchNKeyword);
	$("#curPage").val(1);
	
	$("#pagingForm").submit();			
}

function pageMoveAdd() {
    location.href = './add';
}

function moveNotice() {		
    location.href = '/notice/list';
}

function moveBoard() {		
    location.href = '/board/list';
}

function moveCustomer() {		
    location.href = '/customer/list';
}

/*
function formatDate(dateString) {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    
    return `${year}-${month}-${day} ${hours}:${minutes}`;
}


$("#goBoard").on("click", function() {

	$.ajax({
		url: "/api/board/list",
		type: "GET",
		success: function(data) {
			
			const boardList = data.boardList;
			
			const boardListView = `
				<div id="boardAddButton" style="width: 78.8%; display: flex; justify-content: flex-end;">
					<button onclick="pageMoveAdd();" class="button">게시글 등록</button>
				</div>
					 
					
				<table id="boardTable">
				    <tbody id="boardTableBody">
					<tr>
						<td class="boardTdHead">날짜</td>
						<td class="boardTdHead">제목</td>
						<td class="boardTdHead">작성자</td>
					</tr>
					${boardList.map(item => `
						<tr class="secondTr">
							<td class="boardDateTd">
								${formatDate(item.boardCredate)}
							</td>
							<td class="boardTitleTd">
								<a href="/board/detail?boardNo=${item.boardNo}">${item.boardTitle}</a>
							</td>
							<td class="boardNameTd">${item.memberName}</td>
						</tr>	
					`).join("")}
				    </tbody>
				</table>
			`;
			
			$("#contentDiv").html(boardListView);
		},
		error: function(xhr, status) {
			alert(xhr.status);
        	alert(status);
		}
	});
})*/

/*
<c:forEach var="boardVo" items="${boardList}">
						<tr class="secondTr">
							<td class="boardDateTd">
								<fmt:formatDate value="${boardVo.boardCredate}" pattern="yyyy-MM-dd HH:mm" />
							</td>
							<td class="boardTitleTd">
								<a href="/board/detail?boardNo=${boardVo.boardNo}">${boardVo.boardTitle}</a>
							</td>
							<td class="boardNameTd">${boardVo.memberName}</td>
						</tr>			 
					</c:forEach>	
 */