package com.ybzbcq.designpattern.adapter;

import java.lang.annotation.Target;

public class Adapter extends Source implements TargetAble {

    @Override
    public void method2() {
        System.out.println("This is targetAble method! ");
    }

}
