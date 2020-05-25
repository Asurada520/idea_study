package com.ybzbcq.designpattern.bridge;

public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("This is the second Sub2");
    }
}
