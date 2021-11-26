package cn.itcast.quartz.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@PersistJobDataAfterExecution
public class HelloJob implements Job {

   private String message;

   private Integer count;

    public void  setMessage(String message){
     this.message = message;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
         // 输出当前时间
        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String dateString = dateFormat.format(date);

        // 获取JobDetail的内容
        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println("工作任务的名称"+jobKey.getName()+"   ; 工作任务的组: "+jobKey.getGroup());

        JobDataMap  jobdata=  context.getJobDetail().getJobDataMap();
        Object object = jobdata.get("message");
        System.out.println("Job message: "+ object);

        jobdata = context.getTrigger().getJobDataMap();
        object = jobdata.get("message");
        System.out.println("Trigger message: "+ object);

        System.out.println("读取的message"+message);

        System.out.println("当前任务执行时间: "+ context.getFireTime());
        System.out.println("下次任务执行时间: "+ context.getNextFireTime());

        System.out.println("任务类的名称 "+context.getJobDetail().getJobClass().getName());
        System.out.println("当前时间： "+dateString);

        ++count;

        context.getJobDetail().getJobDataMap().put("count",count);

        System.out.println(count);
    }

}
