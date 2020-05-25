package com.ybzbcq.controller;

import com.alibaba.fastjson.JSONObject;
import com.ybzbcq.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Contended;

@Controller
@RequestMapping("/a/")
public class IndexController {

    @RequestMapping("get")
    public String getInfo(){
        return "aIndex";
    }

    /*@RequestMapping("getBInfo")
    @ResponseBody
    public JSONObject getBInfo(){
        JSONObject result = HttpClientUtils.httpGet("http://b.jade.com:8081/b/getBInfo");
        System.out.println("result:"+ result);
        return result;
    }*/
}
