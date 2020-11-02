package com.jade.controller;


import com.jade.entity.User;
import com.jade.test1.service.UserService1;
import com.jade.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql/")
public class DataSource1MultiController {


    @Autowired
    private UserService1 userService;

    @RequestMapping("1")
    public Object insert(){
        User user = new User();
        user.setId(UuidUtil.get18UUID());
        user.setName("w");
        user.setAge("2");
        int insert = userService.insert(user);
        return insert;
    }

}
