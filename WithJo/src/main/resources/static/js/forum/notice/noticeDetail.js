// noticeDetail.js

function deleteFnc() {        
    if(confirm("해당 공지를 삭제 하시겠습니까?")) {        
        var form = document.getElementById("commonForm");
        form.action = '/notice/delete';
        form.method = 'POST';
        form.submit();        
    } else {        
        alert("공지삭제가 취소 되었습니다!");            
    }
}

function pageMoveUpdate() {
    const noticeNo = window.noticeNo;
    location.href = '/notice/update?noticeNo=' + noticeNo;
}

function pageMoveList() {
    location.href = '/board/list';
}

$(document).ready(function() {
    let noticeContent = $('#noticeContent').val();
    noticeContent = noticeContent.replaceAll("\n", "<br/>");
    $('#divnoticeContent').html(noticeContent);
});