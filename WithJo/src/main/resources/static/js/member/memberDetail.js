$(document).ready(function() {
    setCourseContainerHtml();
});


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
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
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

function detailUpdateFnc(){
	var formData = {
		memberNo: $('input[name="memberNo"]').val(),
		memberZipCode: $('#memberZipCode').val(),
		memberAddress: $('#memberAddress').val(),
		memberAddressInfo: $('#memberAddressInfo').val(),
		authority: $('input[name="authority"]:checked').val()
	};	
	
	
	$.ajax({
		url: '/member/detail',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(formData),
		success: function(response){
			alert('성공적으로 수정되었습니다.');
			location.reload();
		},
		error: function(xhr, status, error){
			alert('업데이트 중 오류가 발생했습니다')
		}
	});		
	
}

function goBack() {
    window.history.back();
}

// 만약 수정 대상 회원이 관리자라면 라디오 버튼을 비활성화



function formatDate() {
	let dateString = $('.memberBirthDate').text();
  // 년(4자리), 월(2자리), 일(2자리)로 분리
  const year = dateString.slice(0, 4);
  const month = dateString.slice(4, 6);
  const day = dateString.slice(6, 8);
  
  let formDateSrting = `${year}년 ${month}월 ${day}일`;
  
  // 형식에 맞게 조합
  return formDateSrting;
}

function formatPhoneNum(){
	let phoneNumString = $(".memberPhoneNum").text();
		
		const firstNum = phoneNumString.slice(0, 3);
		const secondNum = phoneNumString.slice(3, 7);
		const thirdNum = phoneNumString.slice(7, 11);
		 
	let formphoneNumString = `${firstNum} - ${secondNum} - ${thirdNum}` ;
	
	
	return formphoneNumString;
}

$('.memberBirthDate').text(formatDate());
$('.memberPhoneNum').text(formatPhoneNum());



function setCourseContainerHtml() {
    if (!Array.isArray(reserveList)) {
        console.error("Course data is not an array");
        return;
    }

    // 강의별로 데이터 그룹화
    const groupedReserves = reserveList.reduce((acc, reserve) => {
        // 여러 필드를 조합하여 고유 키 생성
        const key = `${reserve.courseNo}-${reserve.courseStartDate}-${reserve.courseEndDate}-${reserve.courseStartTime}-${reserve.courseEndTime}`;
        if (!acc[key]) {
            acc[key] = { ...reserve, courseDays: [] };
        }
        acc[key].courseDays.push(reserve.courseDayOfTheWeek);
        return acc;
    }, {});

    let htmlStr = '<div class="myReserveList">';
    htmlStr += '<div class="myReserveList-header">';
    htmlStr += '<div class="header-item">강의명</div>';
    htmlStr += '<div class="header-item">강의시간/기간</div>';
    htmlStr += '<div class="header-item">강사명</div>';
    htmlStr += '<div class="header-item">수강취소</div>';
    htmlStr += '</div>'; // myReserveList-header 종료

    // 그룹화된 데이터로 HTML 생성
    Object.values(groupedReserves).forEach(reserve => {
        htmlStr += '<div class="myReserveList-item">';
        htmlStr += '<div class="item-content">';
        htmlStr += '<div class="course-name">';
        htmlStr += `<img src="/imges/${reserve.courseMainImage}" alt="강의 이미지">`;
        htmlStr += `${reserve.courseName}`;
        htmlStr += '</div>';
        htmlStr += '</div>';
        htmlStr += '<div class="item-content">[';

        // 요일 정보 처리
        const daysStr = [...new Set(reserve.courseDays)].map(day => {
            switch (parseInt(day)) {
                case 1: return '월';
                case 2: return '화';
                case 3: return '수';
                case 4: return '목';
                case 5: return '금';
                case 6: return '토';
                case 7: return '일';
                default: return day;
            }
        }).sort((a, b) => ['월', '화', '수', '목', '금', '토', '일'].indexOf(a) - ['월', '화', '수', '목', '금', '토', '일'].indexOf(b)).join(', ');

        htmlStr += daysStr;

        // 날짜 형식 포맷
        const startDate = new Date(reserve.courseStartDate);
        const endDate = new Date(reserve.courseEndDate);

        const formattedStartDate = startDate.toLocaleDateString('ko-KR', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit'
        }).replace(/\./g, '.');

        const formattedEndDate = endDate.toLocaleDateString('ko-KR', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit'
        }).replace(/\./g, '.');

        htmlStr += `] <br>${formattedStartDate} ~ ${formattedEndDate}<br>`;
        htmlStr += `${reserve.courseStartTime} ~ ${reserve.courseEndTime}`;
        htmlStr += '</div>';
        htmlStr += `<div class="item-content">${reserve.courseTeacher} 강사</div>`;
        // 수강 취소 버튼
        htmlStr += `<div class="item-content"><button class="reserveCancel" onclick="cancelCourse(${reserve.memberCourseReserveNo}, ${memberNo})">수강취소</button></div>`;
        htmlStr += '</div>'; // myReserveList-item 종료
    });

    htmlStr += '</div>'; // myReserveList 종료
    
    $("#courseContainer").html(htmlStr);
}


function cancelCourse(memberCourseReserveNo) {
    if (confirm("정말로 취소하시겠습니까?")) {
        $.ajax({
            url: '/member/reserve/cancel',
            type: 'POST',
            data: { memberCourseReserveNo: memberCourseReserveNo, memberNo: memberNo },
            success: function(result) {
                if (result === 'success') {
                    alert("취소되었습니다");
                    location.reload(); // 페이지를 새로 고침하여 변경 사항 반영
                } else {
                    alert("취소가 실패되었습니다");
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX 오류:", status, error);
                alert("오류가 발생했습니다: " + error);
            }
        });
    }
}