package com.ybzbcq.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map1 = new Hashtable<String, String>();
        map1.put("1", "");
        map1.put("2", "2");
//        map1.put(null, null);
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put(null, null);
        map1.putAll(stringStringHashMap);


//        Map<String, String> map2 = new HashMap<String, String>();
//        map2.put("2", "2");
//
//        map1.putAll(map2);

        System.out.println(map1.size());

//        String str = " 上海大禾   升平文化传媒有限公司 ";
//        str = str.replaceAll(" +","");
//        System.out.println(str);





    }
}
