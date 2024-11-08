function deleteFnc() {
    if(confirm("해당 게시글을 삭제 하시겠습니까?")) {
        var form = document.getElementById("commonForm");
        form.action = '/board/delete';
        form.method = 'POST';
        form.submit();
    } else {        
        alert("게시글 삭제가 취소 되었습니다!");         
    }
}

function pageMoveUpdate() {
    const boardNo = window.boardNo;
    location.href = '/board/update?boardNo=' + boardNo;
}

function pageMoveList() {
    location.href = '/board/list?curPage=' + prevPage;
}

function commentsList(boardNo) {
    var currentMemberNo = window.currentMemberNo;
    var currentUserAuthority = window.currentUserAuthority;
    $.ajax({
        url: '/comments/list?boardNo=' + boardNo,
        method: 'POST',
        success: function (data) {
            let htmlStr = '';
            for (let i in data.commentsList) {
                htmlStr += '<div class="commentsBox">';
                htmlStr += '<div class="commentsUser">';
                htmlStr += data.commentsList[i].memberName;
                htmlStr += '<span class="commentsDate">' + data.commentsList[i].formattedCDate + '</span>';
                
				htmlStr += '<div class="commentsActions">';

				if (data.commentsList[i].memberNo === currentMemberNo) {
				    htmlStr += '<button class="editComments" data-id="' + data.commentsList[i].commentsNo + '">수정</button>';
				    htmlStr += '<button class="deleteComments" data-id="' + data.commentsList[i].commentsNo + '">삭제</button>';
				} else if(currentUserAuthority >= 1) {
				    htmlStr += '<button class="deleteComments" data-id="' + data.commentsList[i].commentsNo + '">삭제</button>';
				}

				htmlStr += '</div>';
                
                htmlStr += '</div>'; 
                htmlStr += '<div class="commentsCt">' + data.commentsList[i].commentsContent.replace(/\n/g, '<br>') + '</div>';
                htmlStr += '</div>'; 
            }
            $('#commentsList').html(htmlStr);
        },
        error: function(xhr, status) {
            alert(xhr.status);
            alert(status);
        }
    });
}

$(document).ready(function() {
    let boardNo = $('#boardNo').val(); 
    commentsList(boardNo); 

    $(document).on('click', '.deleteComments', function() {
        const commentId = $(this).data('id');
        const confirmation = confirm('정말 삭제하시겠습니까?');

        if (confirmation) {
            $.ajax({
                url: '/comments/delete',
                method: 'POST',
                data: { commentsNo: commentId },
                success: function(response) {
                    location.reload();
                },
                error: function(xhr, status) {
                    alert('삭제에 실패했습니다.');
                }
            });
        }
    });

    $(document).on('click', '.editComments', function() {
        const commentId = $(this).data('id');
        const commentBox = $(this).closest('.commentsBox');
        const commentContent = commentBox.find('.commentsCt').html().replace(/<br>/g, '\n');
        
        // 댓글 내용을 텍스트 영역으로 변경
        commentBox.find('.commentsCt').html('<textarea class="editCommentText">' + commentContent + '</textarea>');
        
        // 수정 완료 버튼 추가
        commentBox.find('.commentsActions').html(
            '<button class="saveComments" data-id="' + commentId + '">수정 완료</button>' +
            '<button class="cancelEdit">취소</button>'
        );
    });

    $(document).on('click', '.cancelEdit', function() {
        commentsList($('#boardNo').val());  // 댓글 목록 새로고침
    });

	$(document).on('click', '.saveComments', function() {
	    const commentId = $(this).data('id');
	    const newContent = $(this).closest('.commentsBox').find('.editCommentText').val();

	    $.ajax({
	        url: '/comments/update',
	        method: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify({ 
	            commentsNo: commentId,
	            commentsContent: newContent
	        }),
	        success: function(response) {
	            commentsList($('#boardNo').val());  // 댓글 목록 새로고침
	        },
	        error: function(xhr, status) {
	            alert('수정에 실패했습니다.');
	        }
	    });
	});

    let boardContent = $('#boardContent').val();
    boardContent = boardContent.replaceAll("\n", "<br/>");
    $('#divBoardContent').html(boardContent);
});