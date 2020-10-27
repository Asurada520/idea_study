package com.jade.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map){
        map.put("name","My angel!");
        return "index";
    }

}
