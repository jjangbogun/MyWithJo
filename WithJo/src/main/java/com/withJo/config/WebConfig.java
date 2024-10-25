package com.withJo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private String connectPath = "/upload/**";
    private String resourcePath;

    public WebConfig() {
        // OS에 따라 resourcePath 설정
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            resourcePath = "file:///C:/upload/";
        } else if (os.contains("mac") || os.contains("nux")) {
            resourcePath = "file:///Users/username/upload/"; // Mac의 경우 적절한 경로로 변경
        } else {
            throw new UnsupportedOperationException("지원하지 않는 운영체제입니다: " + os);
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }
}