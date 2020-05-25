package com.ybzbcq.designpattern.state;

/* 状态 核心类 */
public class State {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println(" execute the first option ");
    }

    public void method2(){
        System.out.println(" execute the second option ");
    }

}
