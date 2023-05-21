package com.zsw.api;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zsw.api")
@MapperScan("com.zsw.api.mapper")
@EnableDubbo
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class,args);
    }
}
