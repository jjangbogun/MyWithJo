function findAddress() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.                   

			} else {
				document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('memberZipCode').value = data.zonecode;
			document.getElementById("memberAddress").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("memberAddressInfo").focus();
		}
	}).open();
}

$(document).ready(function() {

	// 새 비밀번호 유효성 검사
	$(".memberNewPw").on("input", function() {
		var password = $(this).val();
		validatePassword(password, ".memberNewPwMessage");
	});

	function validatePassword(password, messageSelector) {
		var regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,20}$/;

		if (password.length === 0) {
			$(messageSelector).text("").hide();
		} else if (/\s/.test(password)) {
			$(messageSelector).text("비밀번호에 공백을 포함할 수 없습니다.").css("color", "red").show();
		} else if (!regex.test(password)) {
			$(messageSelector).text("영어+숫자 4자 이상이어야 합니다.").css("color", "red").show();
		} else {
			$(messageSelector).text("사용 가능한 비밀번호입니다.").css("color", "green").show();
		}
	}

	// memberUpdateFnc 함수를 전역 스코프로 이동
	window.memberUpdateFnc = function() {
		var newPassword = $('.memberNewPw').val();

		// 비밀번호가 입력된 경우에만 유효성 검사
		if (newPassword && !isPasswordValid(newPassword)) {
			alert("비밀번호 형식이 올바르지 않습니다.");
			return;
		}

		var formData = {
			memberNo: $('input[name="memberNo"]').val(),
			memberZipCode: $('#memberZipCode').val(),
			memberAddress: $('#memberAddress').val(),
			memberAddressInfo: $('#memberAddressInfo').val()
		};

		// 새 비밀번호가 입력된 경우에만 formData에 추가
		if (newPassword) {
			formData.memberPw = newPassword;
		}

		// 서버로 데이터 전송
		$.ajax({
			url: '/member/update',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(formData),
			success: function(response) {
			   /* console.log('Server response:', response);*/
			    if (response.success) {
			        alert(response.message);
			        location.reload();
			    } else {
			        alert(response.message || '업데이트 중 오류가 발생했습니다.');
			    }
			},
			error: function(xhr, status, error) {
			    console.error('AJAX 오류:', status, error);
			    console.log('서버 응답:', xhr.responseText);
			    alert('업데이트 중 오류가 발생했습니다: ' + error);
			}
		});
	};

	function isPasswordValid(password) {
		var regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,20}$/;
		return regex.test(password) && !/\s/.test(password);
	}
});