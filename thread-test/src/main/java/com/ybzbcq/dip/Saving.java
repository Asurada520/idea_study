package com.ybzbcq.dip;

/**
 * 存储账户
 */
public class Saving extends AccountType {
    @Override
    public void deposit(float amt) {
        System.out.println("save Account information");
    }
}
