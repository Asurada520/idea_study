package com.jade.controller;


import com.google.common.util.concurrent.RateLimiter;
import com.jade.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/opr/")
public class OrderOperateController {

    @Autowired
    private OrderService orderService;

    // create 方法中传入一个参数 以每秒为单位固定的速率值 1r/s 每秒中往桶中存入一个令牌
    RateLimiter rateLimiter = RateLimiter.create(1); // 独立线程 产生令牌[token]，并发和生产令牌无关

    @RequestMapping("add")
    public String addOrder(){
        boolean tryAcquire = rateLimiter.tryAcquire(500, TimeUnit.MILLISECONDS);

        //  如果在500毫秒内如果没有获取到令牌的话，则直接走服务降级处理
        if(!tryAcquire){
            System.out.println("请等待一下，再抢购，谢谢");
            return "请等待一下，再抢购，谢谢";
        }

        boolean flag = orderService.addOrder();
        if(flag){
            System.out.println("恭喜您，抢购成功! 等待时间:" + rateLimiter.acquire());
            return "恭喜您，抢购成功!";
        }

        return "Operating is successful.";
    }
}
