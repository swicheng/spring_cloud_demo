package cn.itcast.quartz.listener;

import org.quartz.*;

public class MyTriggerListener implements TriggerListener {


    @Override
    public String getName() {

        String name = this.getClass().getSimpleName();
        System.out.println("监听器的名称是: "+name);

        return name;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {

        String name = trigger.getKey().getName();

        System.out.println(name+"被触发");

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {

        String name = trigger.getKey().getName();
   //在Trigger触发后，Job将要被执行时由Scheduler调用这个方法。TriggerListener给了一个选择去否决Job的执行。加入这个方法返回true，这个Job将不会为此Trigger触发而得到执行
        System.out.println(name+"没有被触发");

        return true;  // true 表示不会执行Job的方法
    }

    @Override
    public void triggerMisfired(Trigger trigger) {

        String name = trigger.getKey().getName();
        System.out.println(name+"错过触发 ");

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {

        String name = trigger.getKey().getName();
        System.out.println(name+" 完成之后触发");

    }


}
