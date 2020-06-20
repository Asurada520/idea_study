package com.jade.service.impl;

import com.jade.annotation.ExtService;
import com.jade.service.OrderService;

@ExtService
public class OrderServiceImpl implements OrderService {

    @Override
    public void add() {
        System.out.println("订单新增成功 ...");
    }
}
