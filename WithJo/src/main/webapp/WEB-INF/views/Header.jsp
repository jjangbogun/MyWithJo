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
								<li><a href="">submenu1</a></li>
								<li><a href="">submenu1</a></li>
								<li><a href="">submenu1</a></li>
							</ul>	
							<div class="ImgDiv"></div>
						</div>
					</li>
					<li class="navElement2">
						<a class="categoryBtn evnetNavBtn">이벤트</a>
						<div class="hiddenDiv hiddenDiv2">
							<ul class="subMenu" >
								<li><a href="">submenu2</a></li>
								<li><a href="">submenu2</a></li>
								<li><a href="">submenu2</a></li>
							</ul>
							<div class="ImgDiv"></div>
						</div>
					</li>
					<li class="navElement3">
						<a class="categoryBtn boardNavBtn">게시판</a>
						<div class="hiddenDiv hiddenDiv3">
							<ul class="subMenu">
								<li><a href="">submenu3</a></li>
								<li><a href="">submenu3</a></li>
								<li><a href="">submenu3</a></li>
							</ul>
							<div class="ImgDiv"></div>
						</div>
					</li>
					<li class="navElement4">
						<a class="categoryBtn aboutNavBtn">이용안내</a>
						<div class="hiddenDiv hiddenDiv4">
							<ul class="subMenu">
								<li><a href="">submenu1</a></li>
								<li><a href="">submenu1</a></li>
								<li><a href="">submenu1</a></li>
							</ul>
							<div class="ImgDiv"></div>
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
