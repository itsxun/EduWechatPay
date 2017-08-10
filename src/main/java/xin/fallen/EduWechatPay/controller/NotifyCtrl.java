package xin.fallen.EduWechatPay.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.fallen.EduWechatPay.Config.GlobalConfig;
import xin.fallen.EduWechatPay.Service.GymOrderSer;
import xin.fallen.EduWechatPay.util.XstreamUtil;
import xin.fallen.EduWechatPay.vo.InitiativeOrderPayRes;
import xin.fallen.EduWechatPay.vo.OrderQueryParam;
import xin.fallen.EduWechatPay.vo.PassiveOrderPayRes;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;

/**
 * Author: Fallen
 * Date: 2017/8/7
 * Time: 15:39
 * Usage:
 */
@RestController
public class NotifyCtrl {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/wxpay-notify")
    public String notifyRecive(HttpServletRequest req) {
        log.info("接到支付通知...");
        InputStream in = null;
        String notifyBody = null;
        try {
            in = req.getInputStream();
            notifyBody = IOUtils.toString(in).trim();
        } catch (Exception e) {
            log.info("解析微信支付消息通知失败，原因是：{}", e.getMessage());
            return GlobalConfig.WECHAT_PAY_FAIL_FEED_BACK;
        }
        log.info("支付通知的数据包为：{}", notifyBody);
        boolean isNotifyBodyValid = false;
        try {
            isNotifyBodyValid = WXPayUtil.isSignatureValid(notifyBody, GlobalConfig.KEY);
            if (!isNotifyBodyValid) {
                throw new Exception();
            }
        } catch (Exception e) {
            log.error("支付通知数据包校验失败");
            return GlobalConfig.WECHAT_PAY_FAIL_FEED_BACK;
        }
        PassiveOrderPayRes wpr = XstreamUtil.Xml2Bean(notifyBody, new PassiveOrderPayRes());
        if (wpr == null) {
            log.error("xml转WechatPayRes异常");
            return GlobalConfig.WECHAT_PAY_FAIL_FEED_BACK;
        }
        if ("FAIL".equals(wpr.getReturnCode())) {
            log.error("交互异常，return code为FAIL");
            return GlobalConfig.WECHAT_PAY_FAIL_FEED_BACK;
        }
        boolean flag = false;
        flag = GymOrderSer.wechatPayResRefresh(wpr);
        if(flag){
            log.info("加入重新获取状态队列：{}",wpr);
        }
        return flag ? GlobalConfig.WECHAT_PAY_SUCCESS_FEED_BACK : GlobalConfig.WECHAT_PAY_FAIL_FEED_BACK;
    }

    @RequestMapping("/pay-state/{orderId}")
    public String getOrderState(@PathVariable("orderId") String orderId) {
        if (orderId == null) {
            return "{\"res\":\"0\",\"msg\":\"请提供订单编号\"}";
        }
        OrderQueryParam oqp = new OrderQueryParam();
        oqp.setAppid(GlobalConfig.APPID);
        oqp.setMchId(GlobalConfig.MCHID);
        oqp.setOutTradeNo(orderId);
        oqp.setNonceStr(WXPayUtil.generateNonceStr());
        Map<String, String> fieldMap = oqp.getFeildMap();
        String sign = "";
        try {
            sign = WXPayUtil.generateSignature(fieldMap, GlobalConfig.KEY);
        } catch (Exception e) {
            log.error("生成签名失败，原因是：{}", e.getMessage());
            return "{\"res\":\"0\",\"msg\":\"生成签名失败\"}";
        }
        oqp.setSign(sign);
        InitiativeOrderPayRes iop = GymOrderSer.getOrderPayRes(oqp);
        if (iop == null) {
            return "{\"res\":\"0\",\"msg\":\"查询失败\"}";
        }
        String res = "";
        try {
            res = new Gson().toJson(iop);
        } catch (Exception e) {
            log.error("查询支付状态失败，原因是：{}", e.getMessage());
            return "{\"res\":\"0\",\"msg\":\"查询失败\"}";
        }
        return res;
    }
}