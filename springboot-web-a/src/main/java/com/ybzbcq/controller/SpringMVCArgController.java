package com.ybzbcq.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import com.ybzbcq.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/arg/")
public class SpringMVCArgController {

    private  static  final Logger logger = LoggerFactory.getLogger(SpringMVCArgController.class);

    @PostMapping(value = "post")
    public String post(@RequestParam(name = "name") String name,
                       @RequestParam(name = "age") Integer age,
                        HttpServletRequest request) {

        StringBuffer requestURL = request.getRequestURL();

        logger.info("url:" + requestURL);
        String content = String.format("name = %s,age = %d", name, age);
        logger.info(content);
        return content;
    }

    @PostMapping(value = "user")
    public Object putUser(User user){
        logger.info(user.toString());

        String userString = "{\"username\":\"liya\",\"gender\":\"female\"}";
        ObjectMapper MAPPER = new ObjectMapper();

        try {
            User userObj = MAPPER.readValue(userString, User.class);
            System.out.println("userObj: " + userObj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    @PostMapping(value = "user2")
    public Object putUser2(@RequestBody User user){
        logger.info(user.toString());

        String userString = "{\"username\":\"liya\",\"gender\":\"female\"}";
        ObjectMapper MAPPER = new ObjectMapper();

        try {
            User userObj = MAPPER.readValue(userString, User.class);
            System.out.println("userObj: " + userObj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    @GetMapping(value = "/user3/{name}/{age}")
    public String findUser1(@PathVariable(value = "age") Integer age,
                            @PathVariable(value = "name") String name) {
        String content = String.format("name = %s,age = %d", name, age);
        logger.info(content);
        return content;
    }

    @GetMapping(value = "/sex/{sex:M|F}")
    public String findUser2(@PathVariable(value = "sex") String sex){
        logger.info(sex);
        return sex;
    }

    @GetMapping(value = "/call/{name}")
    public String find(@PathVariable(value = "name") String name,
                       @MatrixVariable(value = "gender") String gender,
                       @MatrixVariable(value = "group") String group) {
        String content = String.format("name = %s,gender = %s,group = %s", name, gender, group);
        logger.info(content);
        return content;
    }

    @PostMapping(value = "/header")
    public String header(@RequestHeader(name = "Content-Type") String contentType, @CookieValue(name = "JSESSIONID") String sessionId) {
        String content = String.format("contentType = %s", contentType);
        logger.info("{contentType} , {sessionId}", contentType, sessionId);
        return content;
    }

    @PostMapping(value = "/cookie")
    public String cookie(@CookieValue(name = "JSESSIONID") String sessionId) {
        String content = String.format("sessionId = %s", sessionId);
        return content;
    }

}
