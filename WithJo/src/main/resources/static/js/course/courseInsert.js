$(document).ready(function () {
	$('.sumoselect_multiple').SumoSelect ({
	 placeholder :  '요일선택' ,
	 csvDispCount :  5
	});	
	
});

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
	console.log($('.courseNo').val());

function courseInsertPost(){
	
	/*const courseTitle = $('.courseTitle').val();
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
	const courseSubInfo = $('.courseSubInfo').val();
	
	let formData = new FormData();
	let file = $("#fileData")[0].files[0];
	let params = {
		courseName : courseTitle,
		courseTeacher: courseTeacher,
		courseStartDate: courseStartDate,
		courseEndDate: courseEndDate,
		courseStartTime: courseStartTime,
		courseEndTime: courseEndTime,
		courseCost: courseCost,
		courseMaxPeople: courseMax,
		categoryNo: courseSubject,
		courseAgeLimit: courseAge,
		courseRecStart: courseRecStart,
		courseRecEnd: courseRecEnd,
		courseDayOfTheWeek: selectedOptions,
		courseInfo: courseSubInfo
	}
	
	formData.append("file", file);
	formData.append("params", JSON.stringify(params));
	console.log(file);


	console.log("courseTitle: " + courseTitle);
	console.log("courseTeacher: " + courseTeacher);
	console.log("courseStartDate: " + courseStartDate);
	console.log("courseStartDate형식: " + courseStartDate);
	console.log("courseEndDate: " + courseEndDate);
	console.log("courseStartTime: " + courseStartTime);
	console.log("courseEndTime: " + courseEndTime);
	console.log("courseCost: " + courseCost);
	console.log("courseMax: " + courseMax);
	console.log("courseSubject: " +typeof(courseSubject));
	console.log("courseAge: " + courseAge);
	console.log("courseRecStart: " + courseRecStart);
	console.log("courseRecEnd: " + courseRecEnd);
	console.log("selectedOptions: " + typeof(selectedOptions));
	console.log("formData: " + formData);*/
	
						/*
		$.ajax({
				url: '/course/insert',
				method: 'POST',
				data: formData,
				enctype: 'multipart/form-data',
				dataType: 'json',
				contentType : false,
				processData : false, 
				success: function (data) {
					console.log(data);
				}
		});*/
		let selectedOptions = [];
		
		selectedOptions = Array.from(selectElement.selectedOptions).map(option => option.value);
		let selectedSub = $('.selectedSub');
		selectedSub.value = selectedOptions;
		
		document.getElementById("sumoSelectId").submit(); 
};