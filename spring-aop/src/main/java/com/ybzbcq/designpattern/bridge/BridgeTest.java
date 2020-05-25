package com.ybzbcq.designpattern.bridge;

public class BridgeTest {
    public static void main(String[] args) {

        System.out.println("桥接模式工程项目测试");
        System.out.println();

        MyBridge myBridge = new MyBridge();

        SourceSub1 sourceSub1 = new SourceSub1();
        myBridge.setSourceable(sourceSub1);
        myBridge.method();

        System.out.println();

        SourceSub2 sourceSub2 = new SourceSub2();
        myBridge.setSourceable(sourceSub2);
        myBridge.method();


    }
}
