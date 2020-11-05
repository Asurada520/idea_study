package com.jade.service;

import com.jade.dao.UserMapper;
import com.jade.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

//    @Autowired
//    private UserMapper userMapper;

//    @Transactional
//    public User getInfoById(String id){
//        User userResult = userMapper.getInfoById(id);
//        return userResult;
//    }
//
//    public User getInfoById2(String id){
//        User userResult = userMapper.getInfoById(id);
//        return userResult;
//    }

    @Async
    public void asyncTest() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("2 异步调用方法测试");
        return ;
    }

}
