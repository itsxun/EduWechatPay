package xin.fallen.EduWechatPay.job;

import com.github.wxpay.sdk.WXPayUtil;
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
import xin.fallen.EduWechatPay.Config.GlobalConfig;
import xin.fallen.EduWechatPay.Service.GymOrderSer;
import xin.fallen.EduWechatPay.vo.InitiativeOrderPayRes;
import xin.fallen.EduWechatPay.vo.OrderQueryParam;
import xin.fallen.EduWechatPay.vo.PassiveOrderPayRes;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Author: Fallen
 * Date: 2017/6/17
 * Time: 17:57
 * Usage:
 */
@Component
@Configuration
public class WechatPayResRefreshJob extends AbstractCronJob {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${job.wechat_pay_res_refresh.delay}")
    int delay;

    @Value("${job.wechat_pay_res_refresh.cron}")
    String cron;

    @Value("${job.wechat_pay_res_refresh.description}")
    String description;

    @Value("${job.wechat_pay_res_refresh.miss_fire_strategy}")
    String missFireStrategy;

    @Value("${job.wechat_pay_res_refresh.concurrent}")
    boolean concurrent;

    @Override
    @Bean(name = "wechatPayResRefreshJobDetail")
    public MethodInvokingJobDetailFactoryBean jobDetailInject(@Autowired AbstractCronJob wechatPayResRefreshJob) {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setConcurrent(concurrent);
        bean.setTargetObject(wechatPayResRefreshJob);
        bean.setTargetMethod(method);
        return bean;
    }

    @Override
    @Bean(name = "wechatPayResRefreshJobCronTrigger")
    public CronTriggerFactoryBean jobCronTriggerInject(@Qualifier("wechatPayResRefreshJobDetail") JobDetail jobDetail) {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        int index = 2;
        try {
            Field field = CronTrigger.class.getDeclaredField(missFireStrategy.toUpperCase());
            index = field.getInt(null);
        } catch (Exception e) {
            log.error("没有找到配置的miss file strategy，默认 MISFIRE_INSTRUCTION_DO_NOTHING，原因是：{}", e.getMessage());
        }
        bean.setMisfireInstruction(index);
        bean.setJobDetail(jobDetail);
        bean.setCronExpression(cron);
        bean.setStartDelay(delay);
        bean.setDescription(description);
        return bean;
    }

    @Override
    @Bean(name = "wechatPayResRefreshJobScheduler")
    public SchedulerFactoryBean jobSchedulerInject(@Qualifier("wechatPayResRefreshJobCronTrigger") CronTrigger cronTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTrigger);
        return bean;
    }

    @Override
    public void execute() {
        log.info("开始执行重新获取支付状态job");
        PassiveOrderPayRes wpr = GymOrderSer.getReflashMsg();
        if (wpr == null)
            log.error("被要求重新获取支付状态的对象为null，已从队列移除，可能造成就支付状态更新延时或失败");
        OrderQueryParam oqp = new OrderQueryParam();
        oqp.setAppid(wpr.getAppid());
        oqp.setMchId(wpr.getMchId());
        oqp.setNonceStr(wpr.getNonceStr());
        oqp.setOutTradeNo(wpr.getOutTradeNo());
        oqp.setSignType(wpr.getSignType());
        Map<String, String> fieldMap = oqp.getFeildMap();
        String sign;
        try {
            sign = WXPayUtil.generateSignature(fieldMap, GlobalConfig.KEY);
        } catch (Exception e) {
            return;
        }
        oqp.setSign(sign);
        InitiativeOrderPayRes iop = GymOrderSer.getOrderPayRes(oqp);
        try {
            if ("FAIL".equals(iop != null ? iop.getResultCode() : "")) {
                return;
            }
            if ("SUCCESS".equals(iop != null ? iop.getResultCode() : "")) {
                GymOrderSer.wechatPayResNotify(iop);
            }
        } finally {
            oqp = null;
            wpr = null;
        }
    }
}