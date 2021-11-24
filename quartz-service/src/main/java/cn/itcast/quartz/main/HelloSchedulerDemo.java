package cn.itcast.quartz.main;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class HelloSchedulerDemo {

    public static void main(String[] args) throws SchedulerException {

        // 1. 调度器(Scheduler) , 从工厂中获取调度的实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 2. 任务实例(JobDetail)

        // 3. 触发器(Trigger)
    }

}
