package com.ybzbcq.designpattern.singleton;

import java.util.Vector;

/**
 *  1> 创建和getInstance()分开
 *  2> 采用"影子实例"的办法为单例对象的属性同步更新
 */
public class SingletonTest {

    private static SingletonTest instance = null;

    private int temp = -1;

    private Vector propeties = null;

    public Vector getProperties(){
        System.out.println(temp);
        return propeties;
    }

    public SingletonTest() {
    }

    private static synchronized void syncInit(){
        if(instance == null){
            instance = new SingletonTest();
        }
    }

    public static SingletonTest getInstance(){

        if(instance == null){
            syncInit();
        }
        return instance;
    }

    public void updateProperties(int temp){
        SingletonTest singletonTest = new SingletonTest();
        this.temp = temp;
        propeties = singletonTest.getProperties();
    }
}
