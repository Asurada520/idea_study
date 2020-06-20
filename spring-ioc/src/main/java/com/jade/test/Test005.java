package com.jade.test;

import com.jade.ext_spring.ExtAnnotationClassPathXmlApplicationContext;
import com.jade.service.UserService;

public class Test005 {

    public static void main(String[] args) throws Exception {

        ExtAnnotationClassPathXmlApplicationContext app = new ExtAnnotationClassPathXmlApplicationContext("com.jade");
        UserService userService = (UserService)app.getBean("userServiceImpl");
        userService.add();

    }
}
