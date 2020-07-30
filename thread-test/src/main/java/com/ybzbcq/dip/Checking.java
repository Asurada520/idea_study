package com.ybzbcq.dip;

/**
 * 支票账户
 */
public class Checking extends AccountType {
    @Override
    public void deposit(float amt) {
        System.out.println("checking Account information");
    }
}
