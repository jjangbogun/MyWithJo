var swiper = new Swiper(".mySwiper", {
	     slidesPerView: 4,
	     spaceBetween: 30,
	     freeMode: true,
	     pagination: {
	       el: ".swiper-pagination",
	       clickable: true,
	     },
		 navigation: {
		 	    nextEl: ".swiper-button-next",
		 	    prevEl: ".swiper-button-prev",
		 	  },
	   });
	   
let item = $('.item').val();

let cost = $('.costCommaFnc').text();

function costCommaFnc(cost){
	let courseCost = cost.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return courseCost;
 }
 
 $('.costCommaFnc').text(costCommaFnc(cost)+'원');
 
$('.swiper-slide').on("click", () => {
	let courseNo = $('.courseNo').val();
	location.href = "/course/detail?courseNo=" + courseNo;
});

/*$('.noticeBoxElementTxt').on("click", () => {
	let noticeNo = $('.noticeNo').val();
	location.href = "/notice/detail?noticeNo=" + noticeNo;
});*/