package com.ybzbcq.designpattern.memento;

public class MememtoTest {
    public static void main(String[] args) {

        Original original = new Original("tangqq");
        Storage storage = new Storage(original.createMemento());

        System.out.println("修改前状态为：" + original.getValue());
        original.setValue("huangjy");
        System.out.println("修改后状态为：" + original.getValue());

        original.restoreMemento(storage.getMemento());
        System.out.println("修改后状态为：" + original.getValue());

    }
}
