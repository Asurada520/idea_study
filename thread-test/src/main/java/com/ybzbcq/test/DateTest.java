package com.ybzbcq.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @Description 时间测试
 * @since 2019-11-28 16:46
 */

public class DateTest {
    public static void main(String[] args) throws ParseException {

        long nh = 1000 * 60 * 60;

        long currentTime = new Date().getTime();

        String time = "2019-11-28 12:35";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long compareTime = simpleDateFormat.parse(time).getTime();

        System.out.println( "[currentTime:]"+currentTime );
        System.out.println(" [currnetStr:]"+simpleDateFormat.format(new Date()));
        System.out.println( "[compareTime:]"+compareTime );

        System.out.println((currentTime-compareTime)/nh);


    }
}