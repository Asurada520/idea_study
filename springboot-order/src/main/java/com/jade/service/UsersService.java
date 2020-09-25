package com.jade.service;


import com.jade.dao.UsersMapper;
import com.jade.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public List<Users> selectAll(){
        List<Users> users = usersMapper.selectAll();
        return users;
    }

    public int insert(Users users){
        int insert = usersMapper.insert(users);
        return insert;
    }

}
