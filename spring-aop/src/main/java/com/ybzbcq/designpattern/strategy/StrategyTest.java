package com.ybzbcq.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyTest {
    public static void main(String[] args) {
        String exp = "2*8";
        ICalculator  cal = new Multiply();
        int calculate = cal.calculate(exp);
        System.out.println(calculate);

    }
}
