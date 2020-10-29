package com.jade.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

    @RequestMapping("/goIndex")
    public String goIndex(){

        int i = 1/0;

        return "index";
    }

}
