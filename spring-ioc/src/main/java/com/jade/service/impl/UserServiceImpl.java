package com.jade.service.impl;

import com.jade.extannotation.ExtResource;
import com.jade.extannotation.ExtService;
import com.jade.service.OrderService;
import com.jade.service.UserService;

@ExtService
public class UserServiceImpl implements UserService {

    @ExtResource
    private OrderService orderServiceImpl;

    public UserServiceImpl() {
        System.out.println("UserService initialized ... ");
    }

    public void add() {
        orderServiceImpl.add();
        System.out.println("添加用户成功");
    }
}
