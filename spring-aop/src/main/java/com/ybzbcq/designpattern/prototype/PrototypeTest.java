package com.ybzbcq.designpattern.prototype;

import java.io.IOException;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        System.out.println("原型模式项目测试");
        System.out.println("浅拷贝");

        Prototype prototype = new Prototype();
        prototype.setString("tangqq");
        SerializableObject serializableObject = new SerializableObject();
        prototype.setObj(serializableObject);

        SerializableObject obj = prototype.getObj();
        System.out.println(obj);
        System.out.println(prototype.getString());

        /* 浅拷贝 测试*/
        Prototype clone = (Prototype)prototype.clone();
        System.out.println(clone.getObj());
        System.out.println(clone.getString());

        System.out.println();

        /*深拷贝 测试*/
        System.out.println("深拷贝");
        Prototype deepClone = (Prototype)prototype.deepClone();
        System.out.println(deepClone.getObj());
        System.out.println(deepClone.getString());

    }
}
