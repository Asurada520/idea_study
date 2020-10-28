package com.jade.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * freemarker 测试
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map){
        map.put("name","My angel!");
        return "index";
    }

    @RequestMapping("/freemarker")
    public String freemarker(Map<String,Object> map){

        map.put("name","tangqq");
        map.put("sex","2");

        List<String> nameList = new ArrayList<>();
        nameList.add("张青争");
        nameList.add("唐王其");
        nameList.add("王三金");
        map.put("nameList", nameList);

        return "index";
    }

}
