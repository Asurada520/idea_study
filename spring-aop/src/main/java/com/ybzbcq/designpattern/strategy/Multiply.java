package com.ybzbcq.designpattern.strategy;

public class Multiply extends AbstractCalculator implements ICalculator{
    @Override
    public int calculate(String exp) {
        int[] split = split(exp, "\\*");
        return split[0]*split[1];
    }
}
