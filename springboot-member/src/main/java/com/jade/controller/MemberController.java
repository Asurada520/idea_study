package com.jade.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member/")
public class MemberController {

    @RequestMapping("index")
    public Object getMember(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","success");
        result.put("data","member");
        return result;
    }

}
