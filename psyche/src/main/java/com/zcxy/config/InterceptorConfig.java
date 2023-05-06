package com.zcxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    private String filelocation="E:/psyche/src/main/resources/static/upload/img";  // 这两个是路径

    private String filepath="/upload/img/**";

    /**
     * 资源映射到本地路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(filepath)
                .addResourceLocations("file:"+filelocation+"/");
    }

}