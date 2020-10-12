package com.jade.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encode/")
public class EncodeController {

    @RequestMapping("do")
    public Object getUser(String name){
        System.out.println("your input is " + name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        return jsonObject;
    }
}
