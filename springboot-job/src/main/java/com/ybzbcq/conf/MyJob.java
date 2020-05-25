package com.ybzbcq.conf;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

// 任务调度类
public class MyJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz MyJob date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
