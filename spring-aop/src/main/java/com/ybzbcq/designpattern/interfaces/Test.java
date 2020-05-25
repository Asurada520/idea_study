package com.ybzbcq.designpattern.interfaces;

public class Test {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.del();
    }
}
