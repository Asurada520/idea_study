package com.jade.test;

import com.jade.utils.DateUtil;

public class Test {

    public static void main(String[] args) {

        String shortDateFormat = DateUtil.getShortDateFormat(null);
        System.out.println(shortDateFormat);

        String monthFormat = DateUtil.getMonthFormat(null);
        System.out.println(monthFormat);

    }

}
