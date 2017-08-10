package xin.fallen.EduWechatPay.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.google.gson.Gson;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xin.fallen.EduWechatPay.Service.GymOrderSer;
import xin.fallen.EduWechatPay.Config.GlobalConfig;
import xin.fallen.EduWechatPay.util.HttpUtil;
import xin.fallen.EduWechatPay.util.IpUtil;
import xin.fallen.EduWechatPay.util.JsonResultUtil;
import xin.fallen.EduWechatPay.util.XstreamUtil;
import xin.fallen.EduWechatPay.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: Fallen
 * Date: 2017/8/7
 * Time: 11:59
 * Usage:体育中心场馆预定
 */
@RestController
public class OrderCtrl {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private static Gson gson = new Gson();

    @RequestMapping("/new-gym-order")
    public JsonResult WeChatOrderInit(HttpServletRequest req, @NotEmpty(message = "请提供订单ID") @RequestParam("orderId") String orderId, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        OrderInfo orderInfo = GymOrderSer.getOrderInfo(orderId);
        if (orderInfo == null) {
            return JsonResultUtil.resDispatcher("订单异常(errMsg:invalid params)", 0);
        }
        orderInfo.setOrderDesc("苏州国际教育园体育中心-场馆预定");
        String postBody = GymOrderSer.orderParamsXmlBuild(orderInfo, IpUtil.getIpAddr(req));
        log.info("准备请求微信接口，POST数据包为：{}", postBody);
        String callback = null;
        try {
            callback = HttpUtil.post(GlobalConfig.ORDER_CREATE_API, new String(postBody.getBytes(), "ISO8859-1"));
        } catch (Exception e) {
            log.error("向微信服务器发起POST请求失败，原因是：{}", e.getMessage());
            return JsonResultUtil.resDispatcher("下单异常", 0);
        }
        log.info("请求完成，返回值为：{}", callback);
        boolean isCallbackValid = false;
        try {
            isCallbackValid = WXPayUtil.isSignatureValid(callback, GlobalConfig.KEY);
        } catch (Exception e) {}
        if (!isCallbackValid) {
            log.error("微信返回值非法");
            return JsonResultUtil.resDispatcher("下单异常", 0);
        }
        OrderPrepayRes opr = XstreamUtil.Xml2Bean(callback, new OrderPrepayRes());
        if (opr == null) {
            log.error("xml转OrderPrepayRes异常");
            return JsonResultUtil.resDispatcher("预下单异常", 0);
        }
        if (opr.getReturnCode().equals("FAIL")) {
            log.error("与微信服务器通信失败");
            return JsonResultUtil.resDispatcher("与微信服务器通信失败");
        }
        if (opr.getResultCode().equals("FAIL")) {
            log.error("业务失败，错误代码为：{}，错误描述为：{}", opr.getErrCode(), opr.getErrCodeDes());
            return JsonResultUtil.resDispatcher("下单失败");
        }
        OrderPayParam opp;
        try {
            opp = opr.res2Param();
        } catch (Exception e) {
            log.error("OrderPrepayParam对象生成失败，原因是：{}", e.getMessage());
            return JsonResultUtil.resDispatcher("预请求参数生成失败", 0);
        }
        String res = gson.toJson(opp).replace("pack", "package");
        log.info("支付预请求参数为：{}", res);
        return JsonResultUtil.resDispatcher(res);
    }

    @GetMapping("/openid")
    public JsonResult queryOpenid(HttpServletResponse resp, @NotEmpty(message = "请提供查询指定用户的code") String code) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String access_token = GymOrderSer.getAccessToken(GlobalConfig.APPID, GlobalConfig.APP_SECRET);
        if (access_token == null) {
            log.error("获取access_token异常，code为：{}", code);
            return JsonResultUtil.resDispatcher("查询失败", 0);
        }
        WechatUserInfoRes res = GymOrderSer.getUserInfo(access_token, code);
        if (res == null)
            return JsonResultUtil.resDispatcher("获取用户信息失败", 0);
        return JsonResultUtil.resDispatcher(res);
    }
}
