package com.jade.controller;


import com.jade.entity.Users;
import com.jade.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
