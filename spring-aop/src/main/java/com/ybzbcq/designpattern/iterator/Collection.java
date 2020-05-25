package com.ybzbcq.designpattern.iterator;

public interface Collection {
    /*迭代器*/
    public Iterator iterator();
      
    /*取得集合元素*/  
    public Object get(int i);  
      
    /*取得集合大小*/  
    public int size();  
} 