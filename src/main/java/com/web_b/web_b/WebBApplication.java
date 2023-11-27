package com.web_b.web_b;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WebBApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBApplication.class, args);
    }

}
