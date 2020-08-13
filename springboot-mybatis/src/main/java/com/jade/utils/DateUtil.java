package com.jade.utils;

import org.apache.commons.lang.time.FastDateFormat;

import java.util.Date;

public class DateUtil {

    public static String formatDateTime() {
        String format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
        return format;
    }
}
