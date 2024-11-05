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
                
                if (data.commentsList[i].memberNo === currentMemberNo || currentUserAuthority >= 1) {
                    htmlStr += '<div class="commentsActions"><button class="deleteComments" data-id="' + data.commentsList[i].commentsNo + '">삭제</button></div>';
                }
                
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

    let boardContent = $('#boardContent').val();
    boardContent = boardContent.replaceAll("\n", "<br/>");
    $('#divBoardContent').html(boardContent);
});