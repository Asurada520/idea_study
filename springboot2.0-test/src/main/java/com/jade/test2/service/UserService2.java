package com.jade.test2.service;

import com.jade.entity.User;
import com.jade.test2.dao.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService2 {

    @Autowired
    private UserMapper2 userMapper;

    public int insert(User user){
        int count = userMapper.insert(user);
        return count;
    }
}
