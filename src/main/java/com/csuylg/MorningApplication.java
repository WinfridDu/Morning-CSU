package com.csuylg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 *
 * @author dyf
 */
@MapperScan(basePackages = {"com.csuylg.modules.**.mapper"})
@SpringBootApplication
public class MorningApplication extends SpringBootServletInitializer {
    /**
     * 用来测试访问
     */
    @RequestMapping("/")
    public String home() {
        return "hello 朋友";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MorningApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MorningApplication.class, args);
    }
}
