package xin.fallen.EduWechatPay.job;

import com.google.gson.Gson;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import xin.fallen.EduWechatPay.config.GlobalConfig;
import xin.fallen.EduWechatPay.service.GymOrderSer;
import xin.fallen.EduWechatPay.util.HttpUtil;
import xin.fallen.EduWechatPay.vo.Callback;
import xin.fallen.EduWechatPay.vo.InitiativeOrderPayRes;

import java.lang.reflect.Field;

/**
 * Author: Fallen
 * Date: 2017/6/17
 * Time: 17:57
 * Usage:
 */
@Component
@Configuration
public class WechatPayResNotifyJob extends AbstractCronJob {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${job.wechat_pay_notify.delay}")
    int delay;

    @Value("${job.wechat_pay_notify.cron}")
    String cron;

    @Value("${job.wechat_pay_notify.description}")
    String description;

    @Value("${job.wechat_pay_notify.miss_fire_strategy}")
    String missFireStrategy;

    @Value("${job.wechat_pay_notify.concurrent}")
    boolean concurrent;

    @Override
    @Bean(name = "wechatPayResNotifyJobDetail")
    public MethodInvokingJobDetailFactoryBean jobDetailInject(@Autowired AbstractCronJob wechatPayResNotifyJob) {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setConcurrent(concurrent);
        bean.setTargetObject(wechatPayResNotifyJob);
        bean.setTargetMethod(method);
        return bean;
    }

    @Override
    @Bean(name = "wechatPayResNotifyJobCronTrigger")
    public CronTriggerFactoryBean jobCronTriggerInject(@Qualifier("wechatPayResNotifyJobDetail") JobDetail wechatPayResNotifyJobDetail) {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        int index = 2;
        try {
            Field field = CronTrigger.class.getDeclaredField(missFireStrategy.toUpperCase());
            index = field.getInt(null);
        } catch (Exception e) {
            log.error("没有找到配置的miss file strategy，默认 MISFIRE_INSTRUCTION_DO_NOTHING，原因是：{}", e.getMessage());
        }
        bean.setMisfireInstruction(index);
        bean.setJobDetail(wechatPayResNotifyJobDetail);
        bean.setCronExpression(cron);
        bean.setStartDelay(delay);
        bean.setDescription(description);
        return bean;
    }

    @Override
    @Bean(name = "wechatPayResNotifyJobScheduler")
    public SchedulerFactoryBean jobSchedulerInject(@Qualifier("wechatPayResNotifyJobCronTrigger") CronTrigger wechatPayResNotifyJobCronTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(wechatPayResNotifyJobCronTrigger);
        return bean;
    }

    @Override
    public void execute() {
        log.info("开始执行数据库支付状态更新job...");
        String reqUrl = GlobalConfig.WECHAT_PAY_NOTIFY_API;
        if (reqUrl == null) {
            log.error("数据库更新接口地址为null");
            return;
        }
        System.out.println("大小：" + GymOrderSer.NOTIFY_QUEUE.size());
        InitiativeOrderPayRes iop = GymOrderSer.getNotifyMsg();
        System.out.println("大小：" + GymOrderSer.NOTIFY_QUEUE.size());
        if (iop == null) {
            log.error("指定更新数据库支付状态的对象为null");
            return;
        }
        reqUrl = reqUrl.replace("{LSH}", iop.getOutTradeNo()).replace("{WECHATLSH}", iop.getTransactionId()).replace("{OPENID}", iop.getOpenid()).replace("{PAYSTATE}", iop.getTradeState()).replace("{PAYBANK}", iop.getBankType()).replace("{PAYMONEY}", iop.getTotalFee()).replace("{PAYTYPE}", iop.getTradeType()).replace("{RESULTINFO}", iop.getTradeStateDesc());
        log.info("准备向数据库发起更新支付状态请求，地址为：{}", reqUrl);
        String _callback = "";
        try {
            _callback = HttpUtil.get(reqUrl);
        } catch (Exception e) {
            log.error("发起post请求失败，原因是：{}", e.getMessage());
            GymOrderSer.wechatPayResNotify(iop);
            return;
        }
        log.info("请求完成，返回值为：{}", _callback);
        if (_callback != null && _callback.length() > 0) {
            _callback = _callback.replace("null(", "").replace(")", "");
        }
        Callback callback = new Gson().fromJson(_callback, Callback.class);
        if (callback != null && "1".equals(callback.getRes())) {
            log.info("更新成功");
        } else {
            log.error("更新失败");
        }
    }
}