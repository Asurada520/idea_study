package com.ybzbcq.designpattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {

        System.out.println("代理模式工程项目测试");
        Source source = new Source();
        source.method();

        System.out.println();

        Proxy proxy = new Proxy(source);
        proxy.method();

    }
}
