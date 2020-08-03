package com.ybzbcq.quartz;

import com.ybzbcq.conf.MyJob;
import org.quartz.*;
import org.quartz.impl.StdJobRunShellFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class QuratzTest {

    public static void main(String[] args) throws SchedulerException {
        // 创建 scheduler 工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        // 获取调度器
        Scheduler scheduler = sf.getScheduler();
        // 创建 job detail
        JobDetail jd = JobBuilder.newJob(MyJob.class)
                .withDescription("this is a ram job") // job 描述
                .withIdentity("ranJob", "ramGroup")// job name 和 group
                .build();
        // 任务运行的时间，SimpleSchedle类型触发器有效
        long time = System.currentTimeMillis() + 3 * 1000L; // 3秒后启动
        Date startDate = new Date(time);

        Trigger trigger = TriggerBuilder.newTrigger().withDescription("ramTrigger").withIdentity("ramTrigger", "ramTriggerGroup")
                .startAt(startDate)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();

        scheduler.scheduleJob(jd,trigger);
        scheduler.start();

    }


}
