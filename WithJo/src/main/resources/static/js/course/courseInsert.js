$(document).ready(function () {
	$('.sumoselect_multiple').SumoSelect ({
	 placeholder :  '요일선택' ,
	 csvDispCount :  5
	});	
	
});

//첨부파일 이미지 미리보기
function readURL(input) {
	$('#preview1').addClass('courseImg');
	$('#preview2').addClass('courseImg');
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function(e) {
      document.getElementById('preview1').src = e.target.result;
      document.getElementById('preview2').src = e.target.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById('preview1').src = "";
    document.getElementById('preview2').src = "";
  }
}

//강의 시작 , 종료시간 반복
const timeOptions = $('.timeOptions').val();
let htmlStr = '';
for(let i = 9; i <= 18; i++){
	if(i == 9){
		htmlStr += `<option>0${i}:00</option>`;
	}else{
	htmlStr += `<option>${i}:00</option>`;
	}
}
$('.timeOption').html(htmlStr);

//강의 요일 배열 변환
function getSelectedOptions() {
        var selectedOptions = [];
        $('.sumoselect_multiple option:selected').each(function() {
            selectedOptions.push($(this).val());
        });
        return selectedOptions;
    }
	

function courseDateCheck(checkDate){
	const sysdate = new Date();
	const courseStartDate = $('.courseStartDate').val();
	const courseEndDate = $('.courseEndDate').val();
	const courseRecStart = $('.courseRecStart').val();
	const courseRecEnd = $('.courseRecEnd').val();
	
	const courseStartDateChange = new Date(courseStartDate);
	const courseEndDateChange = new Date(courseEndDate);
	const courseRecStartDateChange = new Date(courseRecStart);
	const courseRecEndDateChange = new Date(courseRecEnd);
	
	function stripTime(date) {
	    return new Date(date.getFullYear(), date.getMonth(), date.getDate());
	}
	const sysdateStripped = stripTime(sysdate);
	const courseStartDateStripped = stripTime(courseStartDateChange);
	const courseEndDateChangeStripped = stripTime(courseEndDateChange);
	const courseRecStartDateChangeStripped = stripTime(courseRecStartDateChange);
	const courseRecEndDateChangeStripped = stripTime(courseRecEndDateChange);
	
	switch(checkDate.name){
		
		case "courseStartDate":
			if(courseStartDateStripped < sysdateStripped){
				alert('강의시작 날짜가 현재날짜보다 이전입니다.');
				$('.courseStartDate').focus();
			}else if(courseStartDateStripped > courseEndDateChangeStripped){
				alert('강의종료 날짜가 강의 시작날짜보다 이전입니다.');
				$('.courseStartDate').focus();
			}
			break;
			
		case "courseEndDate":
			if(courseEndDateChangeStripped < sysdateStripped){
				alert('강의종료 날짜가 현재날짜보다 이전입니다.');
				$('.courseEndDate').focus();
			}
			break;
			
		case "courseRecStart":
			if(courseRecStartDateChangeStripped < sysdateStripped){
				alert('접수시작 날짜가 현재날짜보다 이전입니다.');
				$('.courseRecStart').focus();
			}else if(courseRecStartDateChangeStripped > courseRecEndDateChangeStripped){
				alert('접수종료 날짜가 접수시작 날짜보다 이전입니다.');
				$('.courseRecStart').focus();
			}
			break;
			
		case "courseRecEnd":
			if(courseRecEndDateChangeStripped < sysdateStripped){
				alert('접수종료 날짜가 현재날짜보다 이전입니다.');
				$('.courseRecEnd').focus();
			}
			break;
		}
};

//강의 강사명 유효성검사
$('.courseTeacher').on("change", () => {
	const courseTeacher = $('.courseTeacher').val();
	
	if (/\d/.test(courseTeacher)) {
        alert('숫자는 입력할 수 없습니다.');
		$('.courseTeacher').focus();
    }else if (/\s/.test(courseTeacher)) {
	    alert('공백은 입력할 수 없습니다.');
		$('.courseTeacher').focus();
	}else if(!/^[a-zA-Z가-힣]*$/.test(courseTeacher)){
		alert('이름을 올바르게 작성해주세요.');
		$('.courseTeacher').focus();
	}
});

//강의 시작시간 강의 종료시간 유효성검사
$('.timeOption').on("change", () => {
	let startHours = $('.courseStartTime').val().split(":")[0];
	let endHours = $('.courseEndTime').val().split(":")[0];

	if(startHours == '09'){
		startHours = '9';
	}else if(endHours == '09'){
		endHours = '9';
	}

	if(parseInt(startHours) == parseInt(endHours)){
		alert('시작시간과 종료시간이 같습니다.');
		$('.courseStartTime').focus();
	}else if(parseInt(startHours) > parseInt(endHours)){
		alert('시작시간이 종료시간보다 느립니다.');
		$('.courseStartTime').focus();
	}

});

function courseInsertPost(){
	
	let selectedOptions = getSelectedOptions();
	
	const courseTitle = $('.courseTitle').val();
	const courseTeacher = $('.courseTeacher').val();
	const courseStartDate = $('.courseStartDate').val();
	const courseEndDate = $('.courseEndDate').val();
	const courseStartTime = $('.courseStartTime').val();
	const courseEndTime = $('.courseEndTime').val();
	const courseCost = $('.courseCost').val();
	const courseMax = $('.courseMax').val();
	const courseSubject = $('.courseSubjectsSelect').val();
	const courseAge = $('.courseAgeSelect').val();
	const courseRecStart = $('.courseRecStart').val();
	const courseRecEnd = $('.courseRecEnd').val();
	const courseInfo = $('textarea[name="courseInfo"]').val();
	
	let formData = new FormData();
	let file = $("#fileData")[0].files[0];
	
	
	if(file == null){
		alert('메인이미지를 등록해주세요.');
		return false;
	}else if(courseTitle == ''){
		alert('강의명을 등록해주세요.');
		return false;
	}else if(courseTeacher == ''){
		alert('강사명을 등록해주세요.');
		return false;
	}else if(courseStartDate == ''){
		alert('강의시작 날짜를 등록해주세요.');
		return false;
	}else if(courseEndDate == ''){
		alert('강의종료 날짜를 등록해주세요.');
		return false;
	}else if(courseCost == ''){
		alert('수강료를 등록해주세요.');
		return false;
	}else if(courseMax == ''){
		alert('강의 정원을 등록해주세요.');
		return false;
	}else if(courseSubject == ''){
		alert('강의 요일을 등록해주세요.');
		return false;
	}else if(courseAge == ''){
		alert('강의 대상 나이를 등록해주세요.');
		return false;
	}else if(courseRecStart == ''){
		alert('수강신청 시작날짜를 등록해주세요.');
		return false;
	}else if(courseRecEnd == ''){
		alert('수강신청 종료날짜를 등록해주세요.');
		return false;
	}
	
	let params = {
		categoryNo: parseInt(courseSubject),
		courseName : courseTitle,
		courseTeacher: courseTeacher,
		courseCost: parseInt(courseCost),
		courseStartDate: courseStartDate,
		courseEndDate: courseEndDate,
		courseStartTime: courseStartTime,
		courseEndTime: courseEndTime,
		courseMaxPeople: parseInt(courseMax),
		courseAgeLimit: parseInt(courseAge),
		courseRecStart: courseRecStart,
		courseRecEnd: courseRecEnd,
		courseDayOfTheWeek: selectedOptions,
		courseInfo: courseInfo
	}
	
	formData.append("file", file);
	formData.append("params", JSON.stringify(params));
	
		
	 $.ajax({
				url: '/course/insert',
				method: 'POST',
				data: formData,
				dataType: 'json',
				contentType : false,
				processData : false, 
				success: function (data) {
					console.log(data);
					alert(data);
					return "course/list";
				}
		});
		
};