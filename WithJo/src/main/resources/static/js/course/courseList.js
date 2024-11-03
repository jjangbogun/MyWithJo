	
	/*$('.ageElement').on('click', () => {
		
		$('.ageElement.All').css("border-bottom","3px solid");
	});
	$('.ageElement.baby').on('click', () => {
		$('.ageElement.baby').css("border-bottom","3px solid");
	});
	$('.ageElement.youth').on('click', () => {
		$('.ageElement.youth').css("border-bottom","3px solid");
	});
	$('.ageElement.adult').on('click', () => {
		$('.ageElement.adult').css("border-bottom","3px solid");
	});*/
	
	/* 시간 문자열자름 */
	let courseStartTime = $('.courseStartTime').text();
	let subStr1 = courseStartTime.substr(0,5);
	let courseEndTime = $('.courseEndTime').text();
	let subStr2 = courseEndTime.substr(0,5);
	
	$('.courseStartTime').text(subStr1);
	$('.courseEndTime').text(subStr2);
	
	/*let courseCost = $('.courseCost').text();
	courseCost = AddComma(courseCost);
	
	function AddComma(courseCost) {
	 	courseCost = courseCost.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	 	
	 	return courseCost;
	}
	
	$('.courseCost').text(courseCost);*/
	
	function moveCategoryFnc(courseAgeLimit){
		/*console.log(courseAgeLimit);*/
		
			$.ajax({
				url: '/course/list/' + courseAgeLimit,
				method: 'GET',
				contentType: 'application/json',
				dataType: 'json',
				success: function (data) {
					console.log(data);
			
				let htmlStr = '';
					if(data.length == 0){
						htmlStr += '<div><p>등록된강의가없습니다</p></div>';
						$('.courseFlexBox').html(htmlStr);
					}
					data.forEach(course => {
						
							htmlStr += '<div class="courseBox">';
							htmlStr += '<div class="mainImg">메인이미지</div>';
							htmlStr += '<div>';
							htmlStr += '<span>' + course.courseName + '</span>';
							htmlStr += '</div>';
							htmlStr += '<div class="">';
							htmlStr += '<span class="courseStartTime">' +course.courseStartTime +'</span>';
							htmlStr += '<span>~</span>';
							htmlStr += '<span class="courseEndTime">' + course.courseEndTime + '</span>';
							htmlStr += '</div>';
							htmlStr += '<div>';
							htmlStr += '<span class="courseCost">' + course.courseCost + '</span>';
							htmlStr += '</div>';
							htmlStr += '</div>';
							
							$('.courseFlexBox').html(htmlStr);
					});
				
				}
				
			});
			
	};
	
/*	$('.courseBox').on('click', () => {
		let courseNo = $('.numHidden').val();
		alert(courseNo);
		location.href = "/course/courseNo?=" + courseNo;
		location.href = "/course/detail?courseNo=" + courseNo;
	});*/
	
	$('.courseBox').on('click', function() {
	    let courseNo = $(this).find('.numHidden').val();
	    alert(courseNo);
	    location.href = "/course/detail?courseNo=" + courseNo;
	});

	function moveCourseCategoryFnc(categoryNo, courseAgeLimit){
		$.ajax({
				url: '/course/' + categoryNo + '?courseAgeLimit=' + courseAgeLimit,
				method: 'GET',
				contentType: 'application/json',
				dataType: 'json',
				success: function (data) {
					console.log(data);
					
				}		
		});
	}