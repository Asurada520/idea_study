package com.mxingo.getui.platform.demo.test;

import com.gexin.fastjson.JSON;
import com.gexin.fastjson.JSONObject;

public class Test {
    public static void main(String[] args) {

//        JSONObject jsonObject = JSON.parseObject(null);
//
//        System.out.println(jsonObject);

        //测试 int 转 byte
        int int0 = 2;
        byte byte0 = intToByte(int0);
        System.out.println("byte0=" + byte0);//byte0=-22
        //测试 byte 转 int
        int int1 = byteToInt(byte0);
        System.out.println("int1=" + int1);//int1=234

        System.out.println(byte0 == 2);

    }

    //byte 与 int 的相互转换
    public static byte intToByte(int x) {
        return (byte) x;
    }

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }
}
