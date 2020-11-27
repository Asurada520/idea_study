package com.ybzbcq.thread;

/**
 *  获取设备 cpu 内核数目
 */
public class Demo {

    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}
