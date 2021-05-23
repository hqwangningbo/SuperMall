package com.wangningbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangningbo.dao")
public class SuperMallServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuperMallServerApplication.class, args);
    }
}
