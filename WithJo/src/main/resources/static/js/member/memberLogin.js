function signInFnc() {
    var memberId = $("#memberId").val();
    var memberPw = $("#memberPw").val();

    if (!memberId || !memberPw) {
        alert("아이디와 비밀번호를 모두 입력해주세요.");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/member/login",
        data: JSON.stringify({ memberId: memberId, memberPw: memberPw }),
        contentType: "application/json",
        dataType: "json",
        success: function(response) {
            if (response.success) {
                window.location.href = "/"; // 메인 페이지로 리다이렉트
            } else {
                alert("회원 정보가 없습니다. 다시 확인해주세요.");
            }
        },
        error: function() {
            alert("로그인 처리 중 오류가 발생했습니다. 다시 시도해주세요.");
        }
    });
}

$(document).ready(function() {
    // 엔터 키 이벤트 처리
    $("#memberPw").keypress(function(e) {
        if (e.which == 13) { // 엔터 키 코드
            signInFnc();
        }
    });
});