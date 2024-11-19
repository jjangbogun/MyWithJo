var $rightBoxInfo = $(".rightBoxInfo");
     var $inner = $(".courseInner");
     var initialPosition = parseInt($rightBoxInfo.css('top'));
     var innerHeight, rightBoxInfoHeight, maxScroll;

	 let courseCurrentPeopleHidden = $('.courseCurrentPeopleHidden').val();
	 let courseMaxPeopleHidden = $('.courseMaxPeopleHidden').val();
	 
	 if(courseCurrentPeopleHidden == courseMaxPeopleHidden){
		$('.courseResBtnFnc').html(`<a class="courseResBtn"><span>수강인원초과</span></a>`);
		$('.course-Ing').html(`<div class="courseRecEnd">
										<span class="courseRecEndWaitLabel">마감</span>
									</div>`);
	 }
     function updateDimensions() {
         innerHeight = $inner.height();
         rightBoxInfoHeight = $rightBoxInfo.outerHeight();
         maxScroll = innerHeight - rightBoxInfoHeight;
     }
	 
	 function costCommaFnc(cost){
		let courseCost = cost.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		return courseCost;
	 }
	 
	 function courseListReturn(){
		location.href = "/course/list";
	 }
	 
	 let courseCostTxt = $('.courseCostTxt').text();
	 
	 let courseCostTxtChange = costCommaFnc(courseCostTxt);
	 $('.courseCostTxt').text(`${courseCostTxtChange}원`);
	 
     updateDimensions();
     $(window).on('resize', updateDimensions);

     $(window).scroll(function() {
         var currentTop = $(window).scrollTop();
         var innerOffset = $inner.offset().top;
         var relativeScroll = currentTop - innerOffset + initialPosition;

         var newTop = Math.max(0, Math.min(relativeScroll, maxScroll));

         $rightBoxInfo.css({
             "top": newTop + "px"
         });
     });
	 
	 let courseStartTime = $('.courseStartTime').text();
	 	let subStr1 = courseStartTime.substr(0,5);
	 	let courseEndTime = $('.courseEndTime').text();
	 	let subStr2 = courseEndTime.substr(0,5);
	 	
	 	$('.courseStartTime').text(subStr1);
	 	$('.courseEndTime').text(subStr2);
		
		
	let previousHTML = '';
		
	function courseRes(courseNo,memberNo){
		previousHTML = $('.rightBoxInfo').html();
		console.log(memberNo);
		/*alert(courseNo);*/
		$.ajax({
				url: '/course/detail/' + courseNo,
				method: 'GET',
				data: {memberNo : memberNo},
				contentType: 'application/json',
				success: function (data) {
					console.log(data);
					let courseVo = data.courseVo;
					let memberVo = data.memberVo;
					let htmlStr = '';
					
					htmlStr = `<div class="rightBoxInfoInner" style="height: 400px;">
								<div class="scrollArea">
									<div class="popHead">
										<div class="popTopArea">
											<a class="back_course" title="뒤로가기" href="javascript:returnCourse()"><img src="/img/course/back.png" style="width: 32px;
																					height: 32px;"/></a>
										</div>
									</div>
									<div class="costArea">
										<div class="costContentArea">
											<div class="costOption">
												<p class="courseText">수강료</p>
											</div>
											<div class="selectedBox">
												<div>
													<fmt:formatDate value="${courseVo.courseStartDate}" pattern="MM/dd" />
													${courseVo.courseName}
												</div>
												<div class="courseCostComma">${courseVo.courseCost}</div>
											</div>
											<div class="memberEmoneyBox">
												<div class="memberEmoney">
													<p class="courseText">보유한 E-MONEY</p>
												</div>
												<div>
													<p class="memberCostComma">${memberVo.memberEMoney}</p>
												</div>
											</div>
										</div>
									</div>
								</div><!-- scrollArea -->
							</div><!-- rightBoxInfoInner -->
							<div class="courseReservation" style="padding: 22px 31px 40px;">
								<div class="courseResCostBox">
									<div class="courseResCost">
										<p>총 금액</p>
									</div>
									<div class="courseResTotalCost">
										<p class="courseCostComma">${courseVo.courseCost}원</p>
									</div>
								</div>
								<div class="courseResBtnBox">
									<div>
										<a><!--<img alt="." src="/img/common/shoppingCart.png" style="width:30px; height:30px;"/>--></a>
									</div>
									<div>
										<a class="courseResBtn" style="margin-left: 30px; width: 267px;" 
											href="javascript:courseReserve(${courseVo.courseNo},${courseVo.categoryNo},${courseVo.courseCost})"><span>수강신청하기</span></a>
									</div>
								</div>
							</div>`
					$('.rightBoxInfo').html(htmlStr);
					
					/*let courseCostComma = $('.courseCostComma').text();
					courseCost = courseCostComma.replace(/\B(?=(\d{3})+(?!\d))/g, ",");*/
					
					$('.courseCostComma').text(costCommaFnc(`${courseVo.courseCost}원`));
					
					let memberCostComma = $('.memberCostComma').text();
					 let memberCostCommaChange = costCommaFnc(memberCostComma);
						 $('.memberCostComma').text(`${memberCostCommaChange}원`);
				}
				
		});
		
	};
	
	function returnCourse(){
		$('.rightBoxInfo').html(previousHTML);
	}
	
	const memberVo = $('.memberVo').val();
	
	function courseReserve(courseNo,categoryNo,courseCost){
		if(memberVo.length == 0){
			alert('회원가입이 필요합니다.');
			location.href = "/member/login";
		}else if(memberVo == 0){
			let memberNo = $('.memberNo').val();
		
		let memberEmoney = $('.memberEmoneyHidden').val();
		
		if(parseInt(memberEmoney) < courseCost){
			alert('보유한 emoney가 부족합니다.');
			return false;
		}

			let jsonData = {
				courseNo : courseNo,
				memberNo: parseInt(memberNo),
				categoryNo: categoryNo
			};						
			$.ajax({
					url: '/reservation/insert',
					method: 'POST',
					data: JSON.stringify(jsonData),
					contentType: 'application/json',
					success: function (data) {
						alert(data);
						sessionStorage.setItem('loadMemberMypage', 'true');
						location.href = "/course/detail?courseNo=" + courseNo;
					}
			});
		}
	}
	
	function moveCourseList(){
		location.href="/course/list";
	}
	
	function splitDate(date){
		const year = date.getFullYear(); // 2023
		const month = (date.getMonth() + 1).toString().padStart(2, '0'); // 06
		const day = date.getDate().toString().padStart(2, '0'); // 18

		const dateString = year + '-' + month + '-' + day; // 2023-06-18

		return dateString;
	}
	let courseDayArrChange = [];
	let courseDayStr = [];
	function courseUpdateFnc(courseNo){
		let htmlStr = '';
		
		$.ajax({
				url: '/course/update/' + courseNo,
				method: 'GET',
				contentType: 'application/json',
				success: function (data) {
					let courseVo = data.courseVo;
					let courseDay = data.courseDay;
					
					
					for(let i = 0; i < courseDay.length; i ++){
						courseDayStr[i] = courseDay[i].courseListDayNo;
					}
					
					console.log(courseDayStr);
					let courseStartDate = new Date(courseVo.courseStartDate);
					let courseStartDateSplit = splitDate(courseStartDate);
					
					let courseEndDate = new Date(courseVo.courseEndDate);
					let courseEndDateSplit = splitDate(courseEndDate);
					
					let courseRecStart = new Date(courseVo.courseRecStart);
					let courseRecStartSplit = splitDate(courseRecStart);
					
					let courseRecEnd = new Date(courseVo.courseRecEnd);
					let courseRecEndSplit = splitDate(courseRecEnd);

					htmlStr += `<div class="courseDetailInnerBox">
										<div class="courseInner">
											<div class="rightBox">
												<div class="rightBoxFloat">
													<div class="rightBoxInfo">
															<div class="rightBoxInfoInner">
																<div class="scrollArea">
																	<div class="courseInfoTitle">
																		<div class="courseInfoTitleImg">
																			<div>
																				<p>
																					<span class="courseImBox">
																						<img class="courseImg courseImgBefore" alt="." src="/imges/${courseVo.courseMainImage}">
																					</span>
																				</p>
																			</div>
																			<div>
																				<img id="preview1"/>
																			</div>
																		</div>
																		<div class="courseInfoTitleSub">
																			<input type="text" class="courseTitle" value="${courseVo.courseName}" name="courseName" placeholder="수강명을 입력해주세요" required>
																		</div>
																	</div>
																	<div class="courseInfoSub">
																		<div class="courseInfoSubElement teacher">
																			<div class="courseInfoSubElement--flex title">
																				<span>강사명</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<input type="text" class="courseTeacher" name="courseTeacher" placeholder="강사명을 입력해주세요" value="${courseVo.courseTeacher}" required>
																			</div>
																		</div>
																		<div class="courseInfoSubElement aboutCourseDate">
																			<div class="courseInfoSubElement--flex title">
																				<span>강의기간</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<input type="date" class="courseStartDate" value="${courseStartDateSplit}" name="courseStartDate" onchange="courseDateCheckFnc(this);" required>
																				<span>~</span>
																				<input type="date" class="courseEndDate" value="${courseEndDateSplit}" name="courseEndDate" onchange="courseDateCheckFnc(this);" required>
																			</div>
																		</div>
																		<div class="courseInfoSubElement aboutCourseDay">
																			<div class="courseInfoSubElement--flex title">
																				<span>강의요일</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<input type="hidden" value="" name="courseDayOfTheWeek" class="selectedSub">
																				<select id="sumoSelectId" name="sumoSelectName" multiple="multiple" class="sumoselect_multiple" required>
																					<option value="1">월</option>
																					<option value="2">화</option>
																					<option value="3">수</option>
																					<option value="4">목</option>
																					<option value="5">금</option>
																				</select>
																			</div>
																		</div>
																		<div class="courseInfoSubElement aboutCourseTime">
																			<div class="courseInfoSubElement--flex title">
																				<span>강의시간</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<select class="timeOption courseStartTime" name="courseStartTime" required>
																				</select>
																				<span>~</span>
																				<select class="timeOption courseEndTime" name="courseEndTime" required>
																				</select>
																			</div>
																		</div>
																		<div class="courseInfoSubElement cost">
																			<div class="courseInfoSubElement--flex title">
																				<span>수강비용</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<input type="number" class="courseCost number" name="courseCost" value="${courseVo.courseCost}" placeholder="ex) 50000" required>
																			</div>
																		</div>
																		<div class="courseInfoSubElement current">
																			<div class="courseInfoSubElement--flex title">
																				<span>수강정원</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<input type="number" class="courseMax number" name="courseMaxPeople" value="${courseVo.courseMaxPeople}" placeholder="ex) 24" required>
																			</div>
																		</div>
																		<div class="courseInfoSubElement category">
																			<div class="courseInfoSubElement--flex title">
																				<span>과목분류</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<select class="courseSubjectsSelect" name="categoryNo" required>
																					<option value="1">수영</option>
																					<option value="2">테니스</option>
																					<option value="3">탁구</option>
																					<option value="4">골프</option>
																					<option value="5">요가</option>
																				</select>
																			</div>
																		</div>
																		<div class="courseInfoSubElement age">
																			<div class="courseInfoSubElement--flex title">
																				<span>나이제한</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<select class="courseAgeSelect" name="courseAgeLimit" required>
																					<option class="courseAgeCheck" value="${courseVo.courseAgeLimit}" disabled selected>${courseVo.courseAgeLimit}</option>
																					<option>13</option>
																					<option>19</option>
																					<option>20</option>
																				</select>
																			</div>
																		</div>
																		<div class="courseInfoSubElement endCourse">
																			<div class="courseInfoSubElement--flex title">
																				<span>접수기간</span>
																			</div>
																			<div class="courseInfoSubElement--flex detail">
																				<input type="date" class="courseDate courseRecStart" value="${courseRecStartSplit}" name="courseRecStart" onchange="courseDateCheckFnc(this);" required>
																				<span>~</span>
																				<input type="date" class="courseDate courseRecEnd" value="${courseRecEndSplit}" name="courseRecEnd" onchange="courseDateCheckFnc(this);" required>
																			</div>
																		</div>
																	</div>
																</div>
															</div><!-- rightBoxInfoInner -->
															
														</div><!-- rightBoxInfo -->
													</div> <!-- rightBoxFloat -->
												</div> <!-- rightBox -->
												<div class="infoBox">
													<div>
														<input type="file" id="fileData" name="courseMainImage" class="courseMainImage" required onchange="readURL(this)">
														<div>
															<p>
																<span class="courseImBox">
																	<img class="courseImg courseImgBefore" alt="." src="/imges/${courseVo.courseMainImage}">
																</span>
															</p>
														</div>
														<div>
															<img id="preview2"/>
														</div>
													</div>
													<div class="courseInfoText">
														<P style="font-family: '맑은 고딕';font-size: 16pt;font-weight: 700;">
															<span style="background-color:rgb(128 145 188 / 29%);"></span>
														</p>
														<p>
															<span></span>
														</p>
														<div class="courseSubInfo">
														<div class="courseInfo--box">
															<textarea rows="10" cols="90" wrap="hard" style="height: 980px;" name="courseInfo" class="courseSubInfo"
																value = "${courseVo.courseInfo}">${courseVo.courseInfo}</textarea>	
														</div>
														</div>
													</div>
												</div> <!-- infoBox -->
											</div><!-- courseInner -->
										</div>`;
					$('.admin').html(`<div>
											<button onclick="courseUpdatePost(${courseVo.courseNo});">강의수정</button>
										</div>
										<div>
											<button onclick="">돌아가기</button>
										</div>`);
					$('.courseDetailBox').html(htmlStr);
					
					$('.rightBoxInfoInner').css("height", "90%");
					
					var $rightBoxInfo = $(".rightBoxInfo");
					     var $inner = $(".courseInner");
					     var initialPosition = parseInt($rightBoxInfo.css('top'));
					     var innerHeight, rightBoxInfoHeight, maxScroll;

					     function updateDimensions() {
					         innerHeight = $inner.height();
					         rightBoxInfoHeight = $rightBoxInfo.outerHeight();
					         maxScroll = innerHeight - rightBoxInfoHeight;
					     }
						 
						 function costCommaFnc(cost){
							let courseCost = cost.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
							return courseCost;
						 }
						 
						 let courseCostTxt = $('.courseCostTxt').text();
						 
						 let courseCostTxtChange = costCommaFnc(courseCostTxt);
						 $('.courseCostTxt').text(`${courseCostTxtChange}원`);
						 
					     updateDimensions();
					     $(window).on('resize', updateDimensions);

					     $(window).scroll(function() {
					         var currentTop = $(window).scrollTop();
					         var innerOffset = $inner.offset().top;
					         var relativeScroll = currentTop - innerOffset + initialPosition;

					         var newTop = Math.max(0, Math.min(relativeScroll, maxScroll));

					         $rightBoxInfo.css({
					             "top": newTop + "px"
					         });
					     });
					
					let timeOptions = '';
					let startHtmlStr = '';
					let EndHtmlStr = '';
					let categoryOption = '';
					
					categoryOption = `<option class="category" value="${courseVo.categoryNo}" disabled selected></option>`;
					$('.courseSubjectsSelect').prepend(categoryOption);
					
					let category = $(".courseSubjectsSelect option.category").val();
						
						switch(category){
								
								case "1":
									categoryOption = `<option class="category" value="${courseVo.categoryNo}" disabled selected>수영</option>`;
									$('.courseSubjectsSelect option.category').html(categoryOption);
									break;
									
								case "2":
									categoryOption = `<option class="category" value="${courseVo.categoryNo}" disabled selected>테니스</option>`;
									$('.courseSubjectsSelect option.category').html(categoryOption);
									break;
									
								case "3":
									categoryOption = `<option class="category" value="${courseVo.categoryNo}" disabled selected>탁구</option>`;
									$('.courseSubjectsSelect option.category').html(categoryOption);
									break;
									
								case "4":
									categoryOption = `<option class="category" value="${courseVo.categoryNo}" disabled selected>골프</option>`;
									$('.courseSubjectsSelect option.category').html(categoryOption);
									break;
								case "5":
									categoryOption = `<option class="category" value="${courseVo.categoryNo}" disabled selected>요가</option>`;
									$('.courseSubjectsSelect option.category').html(categoryOption);
									break;
								}
						
						if(category === '1'){
							
						}
						
					
					startHtmlStr += `<option class="timeOptions startTime" value="${courseVo.courseStartTime}" disabled selected>${courseVo.courseStartTime}</option>`;
					EndHtmlStr += `<option class="timeOptions endTime" value="${courseVo.courseStartTime}" disabled selected>${courseVo.courseEndTime}</option>`;
					
					function timeOption(){
						for(let i = 9; i <= 18; i++){
							if(i == 9){
								timeOptions += `<option>0${i}:00</option>`;
							}else{
							timeOptions += `<option>${i}:00</option>`;
							}
						}
						return timeOptions;
					}
					
					let timeOptionStr = timeOption();
					
					$('.courseStartTime').html(startHtmlStr + timeOptionStr);
					$('.courseEndTime').html(EndHtmlStr + timeOptionStr);
					
					$('#preview1').hide();
					
					let courseDayArr = [];
					console.log(courseDay[0].courseDayOfTheWeek);
					
					for(let i = 0; i < courseDay.length; i ++){
						courseDayArr[i] = courseDay[i].courseDayOfTheWeek;
						console.log(courseDayArr);
						if(courseDayArr[i] == 1){
							courseDayArr[i] = "월";
						}else if(courseDayArr[i] == 2){
							courseDayArr[i] = "화";
						}else if(courseDayArr[i] == 3){
							courseDayArr[i] = "수";
						}else if(courseDayArr[i] == 4){
							courseDayArr[i] = "목";
						}else if(courseDayArr[i] == 5){
							courseDayArr[i] = "금";
						}
						courseDayArrChange[i] = courseDayArr[i];
					}
				
					$(document).ready(function () {
							$('.sumoselect_multiple').SumoSelect ({
							 placeholder :  [courseDayArrChange] ,
							 csvDispCount :  5
							});	
							
						});
					var courseDayNo = [];
					
				
				}
		});
		
	}

function courseUpdatePost(courseNo){
	let selectedOptions = getSelectedOptions();
	console.log(courseDayStr);
		
		const courseTitle = $('.courseTitle').val();
		const courseTeacher = $('.courseTeacher').val();
		const courseStartDate = $('.courseStartDate').val();
		const courseEndDate = $('.courseEndDate').val();
		let courseStartTime = $('.courseStartTime').val();
		if(courseStartTime == null){
			courseStartTime = $('option.startTime:selected').val();
		}
		let courseEndTime = $('.courseEndTime').val();
		if(courseEndTime == null){
			courseEndTime = $('option.endTime:selected').val();
		}
		const courseCost = $('.courseCost').val();
		const courseMax = $('.courseMax').val();
		let courseSubject = $('.courseSubjectsSelect').val();
		if(courseSubject == null){
			courseSubject = $('option[disabled][selected] .category').val();
		}
		let courseAge = $('.courseAgeSelect').val();
		if(courseAge == null){
			courseAge = $('option.courseAgeCheck:selected').val();
		}
		const courseRecStart = $('.courseRecStart').val();
		const courseRecEnd = $('.courseRecEnd').val();
		const courseInfo = $('textarea[name="courseInfo"]').val();
		
		for(let i = 0; i < selectedOptions.length; i ++){
			if(selectedOptions[i] == '월'){
				selectedOptions[i] = 1;
			}else if(selectedOptions[i] == '화'){
				selectedOptions[i] = 2;
			}else if(selectedOptions[i] == '수'){
				selectedOptions[i] = 3;
			}else if(selectedOptions[i] == '목'){
				selectedOptions[i] = 4;
			}else if(selectedOptions[i] == '금'){
				selectedOptions[i] = 5;
			}
		}
		
		let formData = new FormData();
		let file = $("#fileData")[0].files[0];
		
		let params = {
				courseNo: courseNo,
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
				courseInfo: courseInfo,
				courseListDayNo: courseDayStr
			}
			
			console.log(courseDayStr);
			formData.append("file", file);
			formData.append("params", JSON.stringify(params));
			
			$.ajax({
					url: '/course/update/' + courseNo,
					method: 'POST',
					data: formData,
					contentType : false,
					processData : false, 
					success: function (data) {
						alert(data);
						location.href = "/course/detail?courseNo=" + courseNo;
					}
			});
}

function courseDateCheckFnc(checkDate){
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
	if(courseStartDateStripped < sysdateStripped){
			alert('강의시작 날짜가 현재날짜보다 이전입니다.');
			$('.courseStartDate').val('');
			$('.courseStartDate').focus();
		}else if(courseStartDateStripped > courseEndDateChangeStripped){
			alert('강의종료 날짜가 강의 시작날짜보다 이전입니다.');
			$('.courseEndDate').val('');
			$('.courseEndDate').focus();
		}else if(courseEndDateChangeStripped < sysdateStripped){
			alert('강의종료 날짜가 현재날짜보다 이전입니다.');
			$('.courseEndDate').val('');
			$('.courseEndDate').focus();
		}else if(courseRecStartDateChangeStripped > courseRecEndDateChangeStripped){
			alert('접수종료 날짜가 접수시작 날짜보다 이전입니다.');
			$('.courseRecEnd').val('');
			$('.courseRecEnd').focus();
		}
	
};

	
	