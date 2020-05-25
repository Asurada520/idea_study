package com.ybzbcq.designpattern.proxy;

public class Proxy implements Sourceable {

    private Sourceable sourceable;

    public Proxy(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    @Override
    public void method() {
        System.out.println("Before proxy.");
        sourceable.method();
        System.out.println("After proxy.");
    }
}
