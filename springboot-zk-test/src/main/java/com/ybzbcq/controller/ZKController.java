package com.ybzbcq.controller;


import com.ybzbcq.service.ZKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZKController {

    @Autowired
    private ZKService zkService;

    @RequestMapping("/create")
    public String createNode(){
        String node = zkService.createNode("/jade");
        return node;
    }
}
