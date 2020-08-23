package com.jade.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.jade.service.OrderService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/rate/")
public class RateLimiterController {

    @Autowired
    private OrderService orderService;

    RateLimiter rateLimiter = RateLimiter.create(1);

    @RequestMapping("go")
    public Object test(){
        //double acquire = rateLimiter.acquire();

        boolean token = rateLimiter.tryAcquire(500, TimeUnit.MILLISECONDS);

        if(!token){
            return "server is busying, hold on please!";
        }

        boolean flag = orderService.addOrder();
        if(flag){
            System.out.println("time: " + rateLimiter.acquire());
            return "congratulations, you win!";
        }

        return "sorry，Order is failure!";
    }

    @RequestMapping("go2")
    public Object test2(){
        orderService.addOrder2();

            return "congratulations, you win!";


    }

}
