package com.jade.dao;

import com.jade.entity.Users;

import java.util.List;

public interface UsersMapper {

    public List<Users> selectAll();

    public int insert(Users users);
}
