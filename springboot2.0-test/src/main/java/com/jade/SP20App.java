package com.jade;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@MapperScan("com.jade.dao")
@EnableAsync
@EnableScheduling
public class SP20App {
    public static void main(String[] args) {
        SpringApplication.run(SP20App.class,args);
    }
}
