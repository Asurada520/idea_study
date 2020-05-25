package com.ybzbcq.designpattern.interpret;

public class InterpretTest {
    public static void main(String[] args) {

        Context context = new Context(1, 2);

        int result = new Minus().interpret(new Context(new Plus().interpret(context),3));

        System.out.println(result);


    }
}
