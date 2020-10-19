package com.jade.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/member/")
public class MemberController {

    private AtomicInteger atomicInteger = new AtomicInteger(0);;

    @RequestMapping("index")
    public Object getMember() {
        atomicInteger.incrementAndGet();
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", 200);
        result.put("msg", "success");
        result.put("data", "member");

        System.out.println("详情:" + result+",次数：" + atomicInteger.get());

        return result;
    }

}
