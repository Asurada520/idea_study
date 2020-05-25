package com.ybzbcq.designpattern.templatemethod;

public class TemplateMethodTest {

    public static void main(String[] args) {
        String exp = "8*8";
        AbstractCalculator cal = new Multiply();
        int result = cal.calculate(exp, "\\*");
        System.out.println(result);
    }
}  