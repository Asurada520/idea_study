package com.ybzbcq.designpattern.strategy;

public class Plus extends AbstractCalculator implements ICalculator{
    @Override
    public int calculate(String exp) {
        int[] split = split(exp, "\\+");
        return split[0]+split[1];
    }
}
