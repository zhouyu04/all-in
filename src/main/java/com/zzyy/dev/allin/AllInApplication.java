package com.zzyy.dev.allin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.zzyy.dev.allin.mapper")
public class AllInApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AllInApplication.class, args);
    }

}
