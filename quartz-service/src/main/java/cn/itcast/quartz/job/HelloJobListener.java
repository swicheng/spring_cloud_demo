package cn.itcast.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJobListener implements Job {



    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date =  new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date);

        System.out.println(dateString);
    }


}
