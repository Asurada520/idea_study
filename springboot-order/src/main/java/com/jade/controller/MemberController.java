package com.jade.controller;


import com.jade.enmu.RespCodeDefine;
import com.jade.entity.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openAPI/")
public class MemberController {

    @RequestMapping("getUser")
    public Object getUser(){
        ResponseEntity responseEntity = new ResponseEntity(RespCodeDefine.SUCCESS, "会员信息");
        return responseEntity;
    }

}
