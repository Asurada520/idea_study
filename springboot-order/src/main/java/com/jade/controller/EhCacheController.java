package com.jade.controller;


import com.jade.entity.Users;
import com.jade.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eh/")
public class EhCacheController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("get")
    public Users getInfo(String id){
        Users users = new Users();
        users.setId(id);
        Users usersResult = usersService.selectInfoById(users);
        return usersResult;
    }

}
