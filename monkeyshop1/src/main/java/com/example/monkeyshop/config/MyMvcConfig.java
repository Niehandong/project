package com.example.monkeyshop.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyMvcConfig implements WebMvcConfigurer {

    //配置虚拟路径映射访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射图片保存地址
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:"+System.getProperty("user.dir")+"/src/main/resources/static/");
    }
}
