package com.ybzbcq.designpattern.iterator;

/* 自定义迭代器 */
public interface Iterator {
    //前移  
    public Object previous();  
      
    //后移  
    public Object next();
    /* 是否还有下一个元素*/
    public boolean hasNext();  
      
    //取得第一个元素  
    public Object first();  
} 