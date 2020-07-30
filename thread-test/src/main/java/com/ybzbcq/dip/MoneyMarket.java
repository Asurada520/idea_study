package com.ybzbcq.dip;

/**
 *  金融市场
 */
public class MoneyMarket extends AccountType{
    @Override
    public void deposit(float amt) {
        System.out.println("moneyMarket");
    }
}
