package com.ybzbcq.designpattern.proxy;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("This is a pattern of proxy. original ...");
    }
}
