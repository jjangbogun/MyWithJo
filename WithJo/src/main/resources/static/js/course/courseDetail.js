/*var floatPosition = parseInt($(".rightBoxInfo").css('top'));

// scroll 인식
$(window).scroll(function() {
  
    // 현재 스크롤 위치
    var currentTop = $(window).scrollTop();
    var bannerTop = currentTop + floatPosition + "px";

    //이동 애니메이션
    $(".rightBoxInfo").stop().animate({
      "top" : bannerTop
    }, 300);

});*/


   
   var $rightBoxInfo = $(".rightBoxInfo");
     var $inner = $(".inner");
     var initialPosition = parseInt($rightBoxInfo.css('top'));
     var innerHeight, rightBoxInfoHeight, maxScroll;

     function updateDimensions() {
         innerHeight = $inner.height();
         rightBoxInfoHeight = $rightBoxInfo.outerHeight();
         maxScroll = innerHeight - rightBoxInfoHeight;
     }

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