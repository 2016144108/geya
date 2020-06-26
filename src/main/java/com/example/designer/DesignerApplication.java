package com.example.designer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DesignerApplication extends SpringBootServletInitializer {

//    public static void main(String[] args) {
//        SpringApplication.run(DesignerApplication.class, args);
//    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(DesignerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DesignerApplication.class, args);
    }

}
