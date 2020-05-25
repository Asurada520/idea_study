package com.ybzbcq.designpattern.abstractfactory;

import java.util.logging.Logger;

public class Test {


    public static void main(String[] args) {

        Sender emailProduce = new EmailFactory().produce();
        emailProduce.send();

        Sender msgProduce = new MsgFactry().produce();
        msgProduce.send();

    }
}
