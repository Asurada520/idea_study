package com.ybzbcq.designpattern.decorator;

import org.springframework.util.StringUtils;

public class DecoratorTest {
    public static void main(String[] args) {

        System.out.println("装饰着模式工程项目测试");

        Source source = new Source();
        source.method();

        System.out.println();

        Decorator decorator = new Decorator(source);
        decorator.method();

    }
}
