package com.jade.controller;


import com.jade.annotation.ExtController;
import com.jade.annotation.ExtRequestMapping;

@ExtController
@ExtRequestMapping("/ext")
public class TestController {

    @ExtRequestMapping("/text")
    public String index(){
        System.out.println("ext springMVC implementation ...");
        return "index2";
    }
}
