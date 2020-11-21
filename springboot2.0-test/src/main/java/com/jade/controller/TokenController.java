package com.jade.controller;


import com.jade.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token 模拟session功能
 */

@RestController
@RequestMapping("/token/")
public class TokenController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("put")
    public Object createToken(HttpServletResponse response, String value){
        Object token = tokenService.put(value);
        response.setHeader("sessionID", (String)token);
        return token+", port:" + serverPort;
    }

    @RequestMapping("get")
    public Object getToken(String token){
        Object value = tokenService.get(token);
        return value+", port:" + serverPort;
    }


}
