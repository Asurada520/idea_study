package com.jade.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public boolean addOrder(){
        System.out.println("DB... 正在处理数据 ...");
        return true;
    }
}
