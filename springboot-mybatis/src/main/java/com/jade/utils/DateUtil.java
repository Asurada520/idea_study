package com.jade.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.fasterxml.jackson.databind.util.ISO8601Utils.format;

public class DateUtil {

    private static String longDateFormat ="yyyy-MM-dd HH:mm:ss";

    private static String shortDateFormat = "yyyy-MM-dd";

    private static String monthFormat = "yyyy-MM";

    public static String formatDateTime() {
        String format = FastDateFormat.getInstance(longDateFormat).format(new Date());
        return format;
    }

    public static String getShortDateFormat(String time){

        String result = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(shortDateFormat);
        if(StringUtils.isEmpty(time)){
            result = simpleDateFormat.format(new Date());
        }else{
            try {
                simpleDateFormat = new SimpleDateFormat(longDateFormat);
                Date date = simpleDateFormat.parse(time);
                simpleDateFormat = new SimpleDateFormat(shortDateFormat);
                result = simpleDateFormat.format(date);

            } catch (ParseException e) {
                simpleDateFormat = new SimpleDateFormat(shortDateFormat);
                result = simpleDateFormat.format(new Date());
            }
        }


        return result;
    }

    public static String getMonthFormat(String time){
        String result = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(monthFormat);
        if(StringUtils.isEmpty(time)){
            result = simpleDateFormat.format(new Date());
        }else{
            try {
                simpleDateFormat = new SimpleDateFormat(longDateFormat);
                Date date = simpleDateFormat.parse(time);
                simpleDateFormat = new SimpleDateFormat(monthFormat);
                result = simpleDateFormat.format(date);

            } catch (ParseException e) {
                simpleDateFormat = new SimpleDateFormat(monthFormat);
                result = simpleDateFormat.format(new Date());
            }
        }
        return result;
    }

}
