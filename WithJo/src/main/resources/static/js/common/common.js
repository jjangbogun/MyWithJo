

	
	/* 헤더고정 및 스크롤 감지 */
	var prevScrollTop = 0;

	  document.addEventListener("scroll", function(){
	      
	      var nowScrollTop = $(window).scrollTop(); //현재 스크롤 위치를 nowScrollTop 에 저장
	      
	      if (nowScrollTop > prevScrollTop){ $('header').addClass('active'); } 
	      // 스크롤 방향(Down) 내릴때 -> 헤더에 active 클래스 추가
	      else { $('header').removeClass('active'); } // 스크롤 방향(Up) 올릴때 -> 헤더에 active 클래스 제거
	      prevScrollTop = nowScrollTop;  // prevScroll, nowScrollTop 조건 판단 후, 현재 스크롤값을 prevScrollTop 에 저장

	  });
	   
	/*수강신청 페이지 move*/   
	$('.courseNavBtn').on("click", () => {
		location.href = "/course/list";
	});
	
	/*$('.categoryBtn').mouseover(function(){
		$('.hiddenDiv').addClass('showDiv');
	});*/
	
	$('.navElement1').mouseover(() => {
		$('.hiddenDiv1').addClass('active1');
		$('.active1').show();
		$('.ImgDiv p:eq(0)').addClass('On');
	});
	$('.navElement1').mouseleave(() => {
		$('.hiddenDiv1').removeClass('active1');
	});
	$('.navElement2').mouseover(() => {
		$('.hiddenDiv2').addClass('active1');
		$('.active2').show();
		$('.navElement2 .ImgDiv p:eq(0)').addClass('On');
	});
	$('.navElement2').mouseleave(() => {
		$('.hiddenDiv2').removeClass('active1');
	});
	$('.navElement3').mouseover(() => {
		$('.hiddenDiv3').addClass('active1');
		$('.active3').show();
		$('.navElement3 .ImgDiv p:eq(0)').addClass('On');
	});
	$('.navElement3').mouseleave(() => {
		$('.hiddenDiv3').removeClass('active1');
	});
	$('.navElement4').mouseover(() => {
		$('.hiddenDiv4').addClass('active1');
		$('.active4').show();
	});
	$('.navElement4').mouseleave(() => {
		$('.hiddenDiv4').removeClass('active1');
	});
	
	

	$('.boardNavBtn').on('click', () => {
		location.href = "/notice/list";
	});

/*로그인 페이지 move*/
   $('.loginImg').on("click", () => {
      location.href = "/member/login";
   });
   
   $(".ImgDiv p:first")
   
   $(".courseSubMenuLi1 a").mouseover(() => {
		$('.courseSubMenuLi2').addClass('liHover');
		$('.courseSubMenuLi3').addClass('liHover');
		$('.ImgDiv p:eq(0)').addClass('On');
		$('.ImgDiv p:eq(1)').removeClass('On');
		$('.ImgDiv p:eq(2)').removeClass('On');
   });
   $(".courseSubMenuLi1 a").mouseleave(() => {
   		$('.courseSubMenuLi2').removeClass('liHover');
   		$('.courseSubMenuLi3').removeClass('liHover');
   });
   $(".courseSubMenuLi2 a").mouseover(() => {
   		$('.courseSubMenuLi1').addClass('liHover');
   		$('.courseSubMenuLi3').addClass('liHover');
		$('.ImgDiv p:eq(0)').removeClass('On');
		$('.ImgDiv p:eq(1)').addClass('On');
		$('.ImgDiv p:eq(2)').removeClass('On');
   });
      $(".courseSubMenuLi2 a").mouseleave(() => {
  		$('.courseSubMenuLi1').removeClass('liHover');
  		$('.courseSubMenuLi3').removeClass('liHover');
   });
   $(".courseSubMenuLi3 a").mouseover(() => {
  		$('.courseSubMenuLi1').addClass('liHover');
  		$('.courseSubMenuLi2').addClass('liHover');
		$('.ImgDiv p:eq(0)').removeClass('On');
		$('.ImgDiv p:eq(1)').removeClass('On');
		$('.ImgDiv p:eq(2)').addClass('On');
   });
   $(".courseSubMenuLi3 a").mouseleave(() => {
 		$('.courseSubMenuLi1').removeClass('liHover');
 		$('.courseSubMenuLi2').removeClass('liHover');
	});
	
	
	$(".eventSubMenuLi1 a").mouseover(() => {
		$('.navElement2 .ImgDiv p:eq(0)').addClass('On');
		$('.navElement2 .ImgDiv p:eq(1)').removeClass('On');
	});
	$(".eventSubMenuLi2 a").mouseover(() => {
		$('.navElement2 .ImgDiv p:eq(1)').addClass('On');
		$('.navElement2 .ImgDiv p:eq(0)').removeClass('On');
   });
   
   $(".noticeSubMenuLi1 a").mouseover(() => {
   		$('.navElement3 .ImgDiv p:eq(0)').addClass('On');
   		$('.navElement3 .ImgDiv p:eq(1)').removeClass('On');
   		$('.navElement3 .ImgDiv p:eq(2)').removeClass('On');
   	});
   	$(".noticeSubMenuLi2 a").mouseover(() => {
   		$('.navElement3 .ImgDiv p:eq(0)').removeClass('On');
   		$('.navElement3 .ImgDiv p:eq(1)').addClass('On');
   		$('.navElement3 .ImgDiv p:eq(2)').removeClass('On');
      });
	$(".noticeSubMenuLi3 a").mouseover(() => {
  		$('.navElement3 .ImgDiv p:eq(0)').removeClass('On');
  		$('.navElement3 .ImgDiv p:eq(1)').removeClass('On');
  		$('.navElement3 .ImgDiv p:eq(2)').addClass('On');
  	});
  /*	$(".eventSubMenuLi2 a").mouseover(() => {
  		$('.navElement2 .ImgDiv p:eq(1)').addClass('On');
  		$('.navElement2 .ImgDiv p:eq(0)').removeClass('On');
     });
	$(".eventSubMenuLi1 a").mouseover(() => {
 		$('.navElement2 .ImgDiv p:eq(0)').addClass('On');
 		$('.navElement2 .ImgDiv p:eq(1)').removeClass('On');
	});
	$(".eventSubMenuLi2 a").mouseover(() => {
 		$('.navElement2 .ImgDiv p:eq(1)').addClass('On');
 		$('.navElement2 .ImgDiv p:eq(0)').removeClass('On');
	});*/
