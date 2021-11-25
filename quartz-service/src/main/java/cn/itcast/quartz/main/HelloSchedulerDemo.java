package cn.itcast.quartz.main;

import cn.itcast.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloSchedulerDemo {

    public static void main(String[] args) throws SchedulerException {

        // 1. 调度器(Scheduler) , 从工厂中获取调度的实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 2. 任务实例(JobDetail)
       JobDetail jobDetail = JobBuilder.newJob(HelloJob.class) // 加载任务类，与HelloJob完成绑定，要求HelloJob实现Job接口
                .withIdentity("job1","group1") // 参数1: 任务的名称(唯一实例)
                .usingJobData("message","打印日志") // 传递参数，名称message
                .build();


        // 3. 触发器(Trigger)
       Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1") // 参数1: 触发器的名称(唯一实例) ; 参数2: 触发器组的名称
               .startNow()
               .usingJobData("message","trigger")
               .withSchedule(SimpleScheduleBuilder
                                .simpleSchedule()
                        .withIntervalInSeconds(5) // 每五秒执行一次
                        .repeatForever()
                ).build();

       // 让调度器关联任务和触发器  ， 保证按照触发器定义的条件执行任务
       scheduler.scheduleJob(jobDetail,trigger);
       // 启动
        scheduler.start();
    }


}
