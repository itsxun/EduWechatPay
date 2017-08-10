package xin.fallen.EduWechatPay.job;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Author: Fallen
 * Date: 2017/6/17
 * Time: 17:57
 * Usage:定时任务抽象类
 */
public abstract class AbstractCronJob {

    int delay;//任务延迟

    String cron;//任务定时表达式

    String description;//任务描述

    String missFireStrategy;//任务miss fire策略

    String method = "execute";//定时i任务执行方法

    boolean concurrent;//任务是否允许并发

    public abstract MethodInvokingJobDetailFactoryBean jobDetailInject(AbstractCronJob jobBody);

    public abstract CronTriggerFactoryBean jobCronTriggerInject(JobDetail jobDetail);

    public abstract SchedulerFactoryBean jobSchedulerInject(CronTrigger cronTrigger);

    public abstract void execute();//执行
}