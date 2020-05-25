package com.ybzbcq.designpattern.visitor;

/* 访问者 模式 接口 */
public interface Visitor {

    /**
     * 访问方法
     * @param subject 被访问者 对象
     */
    public void visit(Subject subject);

}
