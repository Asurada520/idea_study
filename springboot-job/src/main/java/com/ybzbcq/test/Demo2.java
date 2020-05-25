package com.ybzbcq.test;

import java.util.Timer;
import java.util.TimerTask;

public class Demo2 {
    private static long count = 0;

    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            public void run() {
                count++;
                System.out.println(count);
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long period = 1000;
        timer.scheduleAtFixedRate(timerTask, delay, period);

    }
}
