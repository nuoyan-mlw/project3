package com.crazycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.crazycode.mapper")
@EnableTransactionManagement
public class Project3Application {

    public static void main(String[] args) {
        SpringApplication.run(Project3Application.class, args);
    }

}
