package com.jade.controller;


import com.jade.entity.TestReqEntity;
import com.jade.entity.Users;
import com.jade.service.UsersService;
import com.jade.utils.TokenUtils;
import com.jade.utils.UuidUtil;
import jdk.nashorn.internal.parser.Token;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users/")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("info")
    public Object selectAll(){
        List<Users> users = usersService.selectAll();
        return users;
    }

    @RequestMapping("token")
    public String getToken(){
        String token = TokenUtils.getToken();
        return token;
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Object addUsers(TestReqEntity reqEntity){

        Users users = new Users();

        String token = reqEntity.getToken();
        System.out.println("token:" + token);
        if(StringUtils.isEmpty(token)){
            return "token is null";
        }

        boolean flag = TokenUtils.findToken(token);
        if(flag){
            users.setId(UuidUtil.get18UUID());
            users.setName(reqEntity.getUsername());
            users.setAge(reqEntity.getPassword());
            usersService.insert(users);
            return "OK";
        }else{

            return "Please do not pull up against.";

        }

    }


}
