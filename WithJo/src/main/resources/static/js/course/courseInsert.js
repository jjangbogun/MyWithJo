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

function getSelectedOptions() {
        var selectedOptions = [];
        $('.sumoselect_multiple option:selected').each(function() {
            selectedOptions.push($(this).val());
        });
        return selectedOptions;
    }
	
function courseInsertPost(){
	/*let selectedOptions = [];
			
	selectedOptions = Array.from(selectElement.selectedOptions).map(option => option.value);
	let selectedSub = $('.selectedSub');
	selectedSub.value = selectedOptions;*/
	
	var selectedOptions = getSelectedOptions();
	
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
	const courseSubInfo = $('.courseSubInfo').val();
	
	let formData = new FormData();
	let file = $("#fileData")[0].files[0];
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
		courseDayOfTheWeek: parseInt(selectedOptions),
		courseInfo: courseSubInfo
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
					alert(data);
					return "course/list";
				}
		});
		
};