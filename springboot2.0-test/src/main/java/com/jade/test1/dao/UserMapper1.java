package com.jade.test1.dao;

import com.jade.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper1 {
    public int insert(User user);
}
