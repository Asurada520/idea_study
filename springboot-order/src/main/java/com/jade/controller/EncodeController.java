package com.jade.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encode/")
public class EncodeController {

    @RequestMapping("")
    public Object getUser(){
        return null;
    }
}
