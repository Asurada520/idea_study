package com.ybzbcq.service;


import com.ybzbcq.entity.Users;
import com.ybzbcq.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<Users> getUser(Integer id) {
        return userMapper.getUser(id);
    }


}
