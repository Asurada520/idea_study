package com.jade.entity;

import java.io.Serializable;

public class Student2 implements Serializable {
    private static final long serialVersionUID = -6794082827332869L;

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
