package com.jade.service.impl;

import com.jade.annotation.ExtService;
import com.jade.service.UserService;
import org.springframework.stereotype.Service;

@ExtService
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("UserService initialized ... ");
    }

    public void add() {
        System.out.println("添加用户成功");
    }
}
