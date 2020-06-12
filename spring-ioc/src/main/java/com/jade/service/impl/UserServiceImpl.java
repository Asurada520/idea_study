package com.jade.service.impl;

import com.jade.service.UserService;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("UserService initialized ... ");
    }

    public void add() {
        System.out.println("添加用户成功");
    }
}
