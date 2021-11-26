package cn.itcast.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJobTrigger implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

         Date date =  new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date);

        System.out.println(dateString);

         Trigger trigger = context.getTrigger();
        System.out.println("任务的开始时间: "+dateFormat.format(trigger.getStartTime()));
        System.out.println("任务的结束时间: "+dateFormat.format(trigger.getEndTime()));
    }

}
