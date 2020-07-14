package com.jade;

import com.jade.conf.ExtClassPathXmlApplicationContext;
import com.jade.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IOC 项目工程测试
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Spring IOC 项目工程测试");

        // xml spring ioc 实现方式测试
        // spring ioc 实用反射机制 xml-dom4j
        ExtClassPathXmlApplicationContext application = new ExtClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService)application.getBean("userService");
        userService.add();


    }
}
