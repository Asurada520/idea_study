package com.jade.task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务 测试
 */
public class Demo2 {

    private static int count = 0;

    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("次数：" + count++);
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);

    }
}
