package com.ybzbcq;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.ybzbcq.mapper")
@EnableCaching
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }
}
