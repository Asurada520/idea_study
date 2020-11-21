package com.jade.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;

@RestController
@RequestMapping("/session/")
public class SessionController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("create")
    public Object createSession(HttpServletRequest request, String value) {
        HttpSession session = request.getSession();
        System.out.println("存入session,sessionId:" + session.getId() + ", value:" + value + ", server port:" + serverPort);
        session.setAttribute("name", value);
        return "success, server port:" + serverPort;
    }

    @RequestMapping("get")
    public Object getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "server port:" + serverPort + ", 该服务器上，不存在对应的 session 值";
        }
        System.out.println("获取session,sessionId:" + session.getId() + ", server port:" + serverPort);
        Object value = session.getAttribute("name");
        return "success, server port:" + serverPort + ", value:" + value;
    }

}
