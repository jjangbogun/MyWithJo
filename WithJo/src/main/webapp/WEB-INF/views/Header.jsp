<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>

	<div class="logoContainer">
		<div class="logo">
			<a href="http://localhost:8888"><img class="logoImg" alt="." src="/img/common/logo.png"></a>
		</div>		
	</div>
	
	<nav>
		<div class="categoryContainer"></div>
			<div class="navBarContainer">
				<ul class="mainMenu">
					<li class="navElement1">
						<a class="categoryBtn courseNavBtn" href="/course/list">수강신청</a>
						<div class="hiddenDiv hiddenDiv1">
							<ul class="subMenu" >
								<li class="courseSubMenuLi1"><a href="">수강검색</a></li>
								<li class="courseSubMenuLi2"><a href="">수강신청·변경·취소안내</a></li>
								<li class="courseSubMenuLi3"><a href="">submenu1</a></li>
							</ul>	
							<div class="ImgDiv">
								<p class="img"><img class="" alt="" src="/img/common/basketball.jpg"/></p>
								<p class="img"><img class="" alt="" src="/img/common/pingpong.jpg"/></p>
								<p class="img"><img class="" alt="" src="/img/common/tenis.jpg"/></p>
							</div>
						</div>
					</li>
					<li class="navElement2">
						<a class="categoryBtn evnetNavBtn" href="/event/list">이벤트</a>
						<div class="hiddenDiv hiddenDiv2">
							<ul class="subMenu" >
								<li class="eventSubMenuLi1"><a href="">로또추첨</a></li>
								<li class="eventSubMenuLi2"><a href="">드로잉</a></li>
							</ul>
							<div class="ImgDiv">
								<p class="img"><img class="" alt="" src="/img/common/event1.jpg"/></p>
								<p class="img"><img class="" alt="" src="/img/common/event2.jpg"/></p>
							</div>
						</div>
					</li>
					<li class="navElement3">
						<a class="categoryBtn boardNavBtn" href="/notice/list">커뮤니티</a>
						<div class="hiddenDiv hiddenDiv3">
							<ul class="subMenu">
								<li class="noticeSubMenuLi1"><a href="">공지사항</a></li>
								<li class="noticeSubMenuLi2"><a href="">게시판</a></li>
								<li class="noticeSubMenuLi3"><a href="">고객센터</a></li>
							</ul>
							<div class="ImgDiv">
								<p class="img"><img class="" alt="" src="/img/common/comunity1.jpg"/></p>
								<p class="img"><img class="" alt="" src="/img/common/comunity2.jpg"/></p>
								<p class="img"><img class="" alt="" src="/img/common/comunity3.jpg"/></p>
							</div>
						</div>
					</li>
					<li class="navElement4">
						<a class="categoryBtn aboutNavBtn" href="/course/list">이용안내</a>
						<div class="hiddenDiv hiddenDiv4">
							<ul class="subMenu">
								<li><a href="">submenu1</a></li>
								<li><a href="">submenu1</a></li>
								<li><a href="">submenu1</a></li>
							</ul>
							<div class="ImgDiv">
								<p class="img On"><img/></p>
								<p class="img On"><img/></p>
								<p class="img On"><img/></p>
							</div>
						</div>
					</li>
				</ul>
			</div>
	</nav>
	
	<div class="sessionContainer">
      <p class="shoppingIcon">
         <a href=""><img class="logoutImg" alt="." src="/img/common/shoppingCart.png"></a>
      </p>
      <c:if test="${sessionScope.memberVo eq null}">
         <p class="loginIcon">
            <img class="loginImg" alt="." src="/img/common/login.png">
         </p>
      </c:if> 
      <c:if test="${sessionScope.memberVo.authority eq 0 || sessionScope.memberVo.authority eq 1}">
 			<a href="<%=request.getContextPath()%>/member/logout"><img class="logoutImg" alt="." src="/img/common/logout.png"></a>
  			<c:choose>
   				<c:when test="${sessionScope.memberVo.authority eq 0}">
     				<a href="/member/update?memberNo=${memberVo.memberNo}"><img class="mypageImg" alt="." src="/img/common/mypage.png"></a>
   				</c:when>
   				<c:when test="${sessionScope.memberVo.authority eq 1}">
     				<a href="/member/list"><img class="mypageImg" alt="." src="/img/common/mypage.png"></a>
    			</c:when>
  			</c:choose>
		</c:if>
   </div>
	
</header>
