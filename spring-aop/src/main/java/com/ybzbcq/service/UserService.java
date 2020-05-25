package com.ybzbcq.service;

import com.ybzbcq.annotation.ExtTransaction;
import com.ybzbcq.dao.UserDao;
import com.ybzbcq.utils.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TransactionUtils transactionUtils;

    @ExtTransaction
    public void addUser(){
        userDao.add("黄飞鸿",20);
//        System.out.println(1/0);
        userDao.add("十三姨",21);
    }
}
