package com.jade.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springboot/")
public class IndexController {

    @RequestMapping("index")
    public Object index(){
//        System.out.println("index");
        return "index";
    }

}
