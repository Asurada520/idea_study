package com.jade.controller;

import com.jade.entity.User;
import com.jade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {


    @Autowired
    private UserService userService;


    @RequestMapping("/hello")
    public Object hello(){
        return "Hello World";
    }

    /* mybatis test*/
    @RequestMapping("/get")
    public Object getUserInfoById(String id){
//        User userResult = userService.getInfoById(id);
//        User userResult2 = userService.getInfoById2(id);
        Map<String,Object> map = new HashMap<>();
//        map.put("user1",userResult);
//        map.put("user2",userResult2);
        return map;
    }

    @RequestMapping("/async")
    public Object asyncTest() throws InterruptedException {

        System.out.println("1");

        userService.asyncTest();

        System.out.println("3");

        return "success";
    }

}
