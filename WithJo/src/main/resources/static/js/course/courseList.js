	
	$('.ageElement.All').on('click', () => {
		$('.ageElement.All').addClass("lineHover");
		$('.ageElement.baby').removeClass("lineHover");
		$('.ageElement.youth').removeClass("lineHover");
		$('.ageElement.adult').removeClass("lineHover");
	});
	$('.ageElement.baby').on('click', () => {
		$('.ageElement.baby').addClass("lineHover");
		$('.ageElement.All').removeClass("lineHover");
		$('.ageElement.youth').removeClass("lineHover");
		$('.ageElement.adult').removeClass("lineHover");
	});
	$('.ageElement.youth').on('click', () => {
		$('.ageElement.baby').removeClass("lineHover");
		$('.ageElement.All').removeClass("lineHover");
		$('.ageElement.youth').addClass("lineHover");
		$('.ageElement.adult').removeClass("lineHover");
	});
	$('.ageElement.adult').on('click', () => {
		$('.ageElement.baby').removeClass("lineHover");
		$('.ageElement.All').removeClass("lineHover");
		$('.ageElement.youth').removeClass("lineHover");
		$('.ageElement.adult').addClass("lineHover");
	});
	
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
	
	function moveCategoryFnc(courseAgeLimit, categoryNo){
		/*console.log(courseAgeLimit);*/
		let now = new Date();
			$.ajax({
				url: '/course/list/' + courseAgeLimit,
				method: 'GET',
				data: { categoryNo: categoryNo },
				contentType: 'application/json',
				dataType: 'json',
				success: function (data) {
				// courseList 배열에 접근
			   var courseList = data.courseList;

			   // categoryList 배열에 접근
			   var categoryList = data.categoryList;
			   
					
				let htmlStr = '';
				let categoryStr = '';
					if(courseList.length == 0){
						htmlStr += '<div style="min-height: 300px;"><p>등록된강의가없습니다</p></div>';
						$('.courseFlexBox').html(htmlStr);
					}
				
					
					courseList.forEach(course => {
						let	courseRecStart = new Date(courseList[0].courseRecStart);
						let	courseRecEnd = new Date(courseList[0].courseRecEnd);
							
							htmlStr += `<div class="courseBox">
											<input class="numHidden" type="hidden" value="${course.courseNo}">
											<div class="mainImg">
												<img alt="." src="/imges/${course.courseMainImage}" class="mainImgHover">
											</div>
											<div class="course-Ing">`;
											if(now > courseRecStart && now < courseRecEnd){
												htmlStr += `<div class="courseRecStart">
																<span class="courseRecStartLabel">접수중</span>
															</div>`;
											}else if(now < courseRecStart){
												htmlStr += `<div class="courseRecStartWait">
																<span class="courseRecStartWaitLabel">접수대기중</span>
															</div>`;
											}else if(now > courseRecEnd && now > courseRecStart){
												htmlStr += `<div class="courseRecEnd">
																<span class="courseRecEndWaitLabel">마감</span>
															</div>`;
											}
							htmlStr +=	`</div>
										    <div>
										      <span>${course.courseName}</span>
										    </div>
										    <div class="">
										      <span class="courseStartTime">${course.courseStartTime}</span>
										      <span>~</span>
										      <span class="courseEndTime">${course.courseEndTime}</span>
										    </div>
										    <div>
										      <span class="courseCost">${course.courseCost}</span>
										    </div>
											<input type="hidden" val="${course.courseAgeLimit}" class="hidden">
									  	</div>
									`;
							
							$('.courseFlexBox').html(htmlStr);
							
					});
					
					if(categoryList.length === 0){
						$('.categorySelectList').html('');
						$('.ageCategory').addClass('ageCategoryBorder');
					}
					categoryAll = `<div class="categoryList">
									<div class="categoryAll">
										<p>전체</p>
									</div>
									<div style="margin-top:4px;">
										<a onclick="">전체</a>
									</div>
									</div>`;
					categoryList.forEach(category => {
						$('.ageCategory').removeClass('ageCategoryBorder');
						categoryStr+= `<div class="categoryList">
											<div>`
						switch(category.categoryName){
								
							case "수영":
								categoryStr+= `<img src="/img/common/swim.jpg"/>`;
								break;
							case "테니스":
								categoryStr+= `<img src="/img/common/tenis.jpg"/>`;
								break;
							case "탁구":
								categoryStr+= `<img src="/img/common/pingpong.jpg"/>`;
								break;
							case "골프":
								categoryStr+= `<img src="/img/common/golf.jpg"/>`;
								break;
							case "요가":
								categoryStr+= `<img src="/img/common/yoga.jpg"/>`;
								break;
						}
							
						categoryStr+=		`</div>
											<div>
												<a onclick="">${category.categoryName}</a>
											</div>
										</div>`;
						$('.categorySelectList').html(categoryAll+categoryStr);
						
					})
					
					$('.courseBox').on('click', function() {
					    let courseNo = $(this).find('.numHidden').val();
					    location.href = "/course/detail?courseNo=" + courseNo;
					});

					
					/*
					data.forEach(course =>{
						
						htmlStr1+= `<div class="categoryList limit">
										<button onclick="moveCategoryFnc(${course.courseAgeLimit}, ${course.categoryNo});">${course.categoryName}</button>
									</div>`
						if(courseAgeLimit == 0 && categoryNo == 0){
							$('.categorySelectList').html('');
						};							
						$('.categorySelectList').html(htmlStr1);
					});*/
				
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
	    location.href = "/course/detail?courseNo=" + courseNo;
	});

	/*function moveCourseCategoryFnc(categoryNo, courseAgeLimit){
		$.ajax({
				url: '/course/' + categoryNo + '?courseAgeLimit=' + courseAgeLimit,
				method: 'GET',
				contentType: 'application/json',
				dataType: 'json',
				success: function (data) {
					console.log(data);
					
				}		
		});
	}*/
	
	function courseInsert(){
		location.href="/course/insert";
	}