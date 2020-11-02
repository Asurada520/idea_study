package com.jade.test1.service;

import com.jade.entity.User;
import com.jade.test1.dao.UserMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService1 {

    @Autowired
    private UserMapper1 userMapper;

    public int insert(User user){
        int count = userMapper.insert(user);
        return count;
    }
}
