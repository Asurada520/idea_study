package com.ybzbcq.proxy;


import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void insert() {
        System.out.println("保存用户数据成功");
    }
}
