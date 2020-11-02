package com.jade.test2.dao;

import com.jade.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper2 {
    public int insert(User user);
}
