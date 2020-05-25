package com.ybzbcq.designpattern.decorator;

public class Decorator implements SourceAble{

    private SourceAble sourceAble;

    public Decorator(SourceAble sourceAble) {
        super();
        this.sourceAble = sourceAble;
    }

    @Override
    public void method() {
        System.out.println("Before Decorator");
        sourceAble.method();
        System.out.println("After Decorator");
    }
}
