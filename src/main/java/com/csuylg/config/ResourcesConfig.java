package com.csuylg.config;

import com.csuylg.common.utils.FileUploadUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通用配置
 * 
 * @author dyf
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 本地文件上传路径
        registry.addResourceHandler(FileUploadUtils.RESOURCE_PREFIX + "/**").addResourceLocations("file:" + MorningConfig.getProfile() + "/");
    }
}