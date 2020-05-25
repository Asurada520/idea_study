package com.ybzbcq.designpattern.singleton;

import java.util.Vector;

public class Test {

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
//            SingletonTest singletonTest = new SingletonTest();
            SingletonTest instance = SingletonTest.getInstance();
            instance.updateProperties(i);
            System.out.println(instance);
//            System.out.println();
            Vector properties = instance.getProperties();
//            System.out.println();
            System.out.println("=======================");

        }

    }
}
