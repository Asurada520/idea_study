package com.ybzbcq.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${jade_port:80801}")
    private String port;

    @RequestMapping("/get")
    public Object get(){
        System.out.println("port:" + port);
        return port;
    }
}
