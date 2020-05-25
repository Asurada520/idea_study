package com.ybzbcq.designpattern.iterator;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
  
    public static void main(String[] args) {
        Collection collection = new MyCollection();  
        Iterator iterator = collection.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*List<Map> list = new ArrayList<>();
        List<String> list2 = null;
        if(!CollectionUtils.isEmpty(list2)){
            System.out.println(list.size());
        }else{
            System.out.println("list2 is empty");
        }*/

    }  
}  