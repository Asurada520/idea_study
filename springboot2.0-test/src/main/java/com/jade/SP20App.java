package com.jade;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.jade.dao")
public class SP20App {
    public static void main(String[] args) {
        SpringApplication.run(SP20App.class,args);
    }
}
