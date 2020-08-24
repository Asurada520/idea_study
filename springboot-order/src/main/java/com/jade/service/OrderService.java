package com.jade.service;

import com.jade.annotation.ExtRateLimiter;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public boolean addOrder(){
        System.out.println("DB... 正在处理数据 ...");
        return true;
    }

    @ExtRateLimiter(value = 1, timeOut = 500)
    public void addOrder2(){
        System.out.println("DB... 正在处理数据 ...");
        return ;
    }


}
