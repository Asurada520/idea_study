package com.ybzbcq.designpattern.strategy;

public class Minus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] split = split(exp, "-");
        return split[0]-split[1];
    }
}
