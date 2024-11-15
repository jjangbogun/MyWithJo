package com.withJo.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.withJo.member.domain.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    String requestURI = request.getRequestURI();

    MemberVo member = (MemberVo) session.getAttribute("memberVo");
    
    // 회원 전용 페이지 체크
    if ("/member/myPage".equals(requestURI) || "/board/add".equals(requestURI)
    		|| "/customer/add".equals(requestURI) || "/board/update".equals(requestURI)) {
      if (member == null) {
//        String message = "로그인이 필요한 서비스입니다.";
//        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
        response.sendRedirect("/member/login");
        return false;
      }
    }
    
    // 관리자 전용 페이지 체크
    if ("/member/list".equals(requestURI) || "/notice/add".equals(requestURI) || "/customer/update".equals(requestURI) 
    		|| "/notice/update".equals(requestURI) || "/lotto/list".equals(requestURI) || "/lotto/add".equals(requestURI)
    		 || "/drawing/add".equals(requestURI)) {
      if (member == null || member.getAuthority() != 1) {
        response.sendRedirect("/error/403");
        return false;
      }
    }

    return true;
  }
}
