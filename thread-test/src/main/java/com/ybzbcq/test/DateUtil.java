package com.ybzbcq.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final String formatStr = "HH:mm";
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    

    private static boolean isInZone(long tStart,long tEnd,long t) throws ParseException {
        return tStart <= t && t <= tEnd;
    }

    private static long getLong(String timeStr) throws ParseException {
        return sdf.parse(timeStr).getTime();
    }
    private static long getLong2(String timeStr) throws ParseException {
    	DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	DateFormat format2 = new SimpleDateFormat("HH:mm");
    	return sdf.parse(format2.format(format1.parse(timeStr))).getTime();
    }
    
    
    
    private static long getCurrentTime() throws ParseException {
        return getLong(sdf.format(new Date()));
    }
    
    public static boolean isInZone(String start, String end, String currentTime) throws ParseException {
    	long current = getLong2(currentTime);
        long startLong = getLong(start);
        long endLong = getLong(end);
        if(startLong <= endLong){
            return isInZone(startLong, endLong,current);
        }

        if (isInZone(getLong(start), getLong("24:00"), current) || isInZone(getLong("00:00"), getLong(end), current)) {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String args[]) throws ParseException {
        String tS = "05:00";
        long aLong = getLong(tS);
        System.out.println(aLong);
        String tE = "05:00";
        String middle = "2019-11-29 05:00";
        boolean inZone = isInZone(tS, tE, middle);
        System.out.println(inZone);
        if(inZone){
          System.out.println(111);
        }else{
            System.out.println(inZone);
        }
    }
}
