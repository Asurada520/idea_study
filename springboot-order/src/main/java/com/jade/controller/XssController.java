package com.jade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/xss/")
public class XssController {


    @RequestMapping("index")
    public String doXss(){
        return "index";
    };

    @RequestMapping("postIndex")
    public String postIndex(HttpServletRequest request){
        String name = request.getParameter("name");
        request.setAttribute("name",name);
        return "forward";
    };
}
