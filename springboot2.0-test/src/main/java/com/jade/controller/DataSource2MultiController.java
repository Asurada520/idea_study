package com.jade.controller;


import com.jade.entity.User;
import com.jade.test2.service.UserService2;
import com.jade.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql/")
public class DataSource2MultiController {


    @Autowired
    private UserService2 userService;

    @RequestMapping("2")
    public Object insert(){
        User user = new User();
        user.setId(UuidUtil.get18UUID());
        user.setName("w");
        user.setAge("2");
        int insert = userService.insert(user);
        return insert;
    }

}
