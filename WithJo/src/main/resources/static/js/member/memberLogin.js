$(document).ready(function() {
    // 모달 관련 변수
    var $modal = $("#findAccountModal");
    var $btn = $(".signinFind_btn");
    var $span = $(".close");

    // 아이디/비밀번호 찾기 버튼 클릭 시 모달 열기
    $btn.on("click", function() {
        $modal.css("display", "block");
    });

    // 모달 닫기
    $span.on("click", function() {
        $modal.css("display", "none");
    });

    // 모달 외부 클릭 시 닫기
    $(window).on("click", function(event) {
        if (event.target == $modal[0]) {
            $modal.css("display", "none");
        }
    });

    // 엔터 키 이벤트 처리
    $("#memberPw").keypress(function(e) {
        if (e.which == 13) { // 엔터 키 코드
            signInFnc();
        }
    });

    // signInFindFnc 함수를 버튼 클릭 이벤트에 직접 연결
    $(".signinFind_btn").on("click", function() {
        $modal.css("display", "block");
    });
});

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



// 아이디/비밀번호 찾기 함수
function findAccount(type) {
  var name = $("#findName").val();
  var id = $("#findId").val();

  if (!name) {
    alert("이름을 입력해주세요.");
    return;
  }

  if (type === 'password' && !id) {
    alert("아이디를 입력해주세요.");
    return;
  }

  $.ajax({
    type: "POST",
    url: "/member/find" + (type === 'id' ? "Id" : "Pw"),
    data: JSON.stringify({ memberName: name, memberId: id }),
    contentType: "application/json",
    dataType: "json",
    success: function(response) {
		if (response.success) {
			if (type === 'id') {
		        $("#findResult").html("찾은 아이디: " + response.memberId);
		    } else {
		        $("#findResult").html("비밀번호가 초기화되었습니다. 로그인 후 변경해주세요.");
		    }
		} else {
		    $("#findResult").html("일치하는 정보가 없습니다.");
		}
		},error: function() {
			$("#findResult").html("오류가 발생했습니다. 다시 시도해주세요.");
		}
	});
}

