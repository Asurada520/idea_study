package com.ybzbcq.designpattern.iterator;

public class MyCollection implements Collection {
  
    public String string[] = {"格物","致和","诚意","正心","修身","齐家","治国","修天下"};
    /*格物、致和、诚意、正心、修身、齐家、治国、修天下*/

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }  
  
    @Override  
    public Object get(int i) {
        return string[i];  
    }  
  
    @Override  
    public int size() {
        return string.length;  
    }  
}  