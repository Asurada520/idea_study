package com.ybzbcq.designpattern.bridge;


public class MyBridge extends Bridge {
    @Override
    public void method() {
        getSourceable().method();
    }
}
