package com.ybzbcq.designpattern.visitor;

public class VisitTest {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject subject = new MySubject();
        subject.accept(visitor);
    }
}
