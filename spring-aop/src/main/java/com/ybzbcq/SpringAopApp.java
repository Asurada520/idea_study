package com.ybzbcq;

import com.ybzbcq.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.addUser();
    }
}
