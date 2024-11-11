package com.withJo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.withJo.util.AuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private AuthInterceptor authInterceptor;
    private String connectPath = "/upload/**";
    private String resourcePath;

    public WebConfig() {
        // OS에 따라 resourcePath 설정
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            resourcePath = "file:///C:/upload/";
        } else if (os.contains("mac") || os.contains("nux")) {
            resourcePath = "file:///Users/kimyk/upload/"; // Mac의 경우 적절한 경로로 변경
        } else {
            throw new UnsupportedOperationException("지원하지 않는 운영체제입니다: " + os);
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(authInterceptor)
          .addPathPatterns("/member/list", "/member/myPage", "/customer/detail", "/notice/add", "/board/add", "/customer/add"
        		  , "/customer/update", "/notice/update", "/board/update", "/lotto/list", "/lotto/add", "/drawing/add", "/drawing/list")
          .excludePathPatterns("/", "/member/add", "/member/login", "/board/list", "/notice/list", "/customer/list"
        		  , "/board/detail",  "/notice/detail", "/customer/list", "/lotto/detail", "/drawing/detail"
        		  , "/event/list", "/course/list", "/css/**", "/js/**", "/img/**");
    }
}