package com.ybzbcq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class TestSessionController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/")
    public String index(){
        System.out.println(serverPort);
        return "server port:"+ serverPort;
    }

    @RequestMapping("/cs")
    public String createSession(HttpServletRequest request, String value){

        HttpSession session = request.getSession();
        System.out.println("当前 session 信息， session id 是：" + session.getId()+", server port: " + serverPort);
        session.setAttribute("name", value);
        return "server Port: " + serverPort + " success ";
    }

    @RequestMapping("gs")
    public Object getSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null){
            return " 当前无 session 可用";
        }
        System.out.println("当前 session 信息， session id 是：" + session.getId()+", server port: " + serverPort);
        Object name = session.getAttribute("name");
        return "server port:"+ serverPort + ", get attribute info : " + name;
    }
}
