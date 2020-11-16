package com.jade.distributelock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderIDGenerator {

    private static int count = 0;

    public String getID(){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(new Date());

        return format1+"-"+count++;
    }

}
