package com.ybzbcq.designpattern.visitor;

/* 被访问者 对象 */
public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}
