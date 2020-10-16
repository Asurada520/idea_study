package com.jade.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public Object hello(){
        System.out.println("return:" + "Hello World");
        return "Hello World";
    }
}
