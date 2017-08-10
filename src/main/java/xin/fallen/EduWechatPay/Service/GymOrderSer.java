package xin.fallen.EduWechatPay.Service;

import com.github.wxpay.sdk.WXPayUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xin.fallen.EduWechatPay.Config.GlobalConfig;
import xin.fallen.EduWechatPay.po.OrderInitParams;
import xin.fallen.EduWechatPay.util.HttpUtil;
import xin.fallen.EduWechatPay.util.XstreamUtil;
import xin.fallen.EduWechatPay.vo.*;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Author: Fallen
 * Date: 2017/8/7
 * Time: 12:42
 * Usage:
 */
public class GymOrderSer {
    private static Logger log = LoggerFactory.getLogger("GymOrderSer");

    private static BlockingDeque<PassiveOrderPayRes> WECHAT_PAY_RES_REGET = new LinkedBlockingDeque<>();

    public static BlockingDeque<InitiativeOrderPayRes> NOTIFY_QUEUE = new LinkedBlockingDeque<>();

    public static OrderInfo getOrderInfo(String orderId) {
        String addr = GlobalConfig.ORDER_FEE_API.replace("{LSH}", orderId);
        String res = "";
        try {
            res = HttpUtil.get(addr);
        } catch (Exception e) {
            log.error("发起get请求失败，原因是：{}", e.getMessage());
            return null;
        }
        res = res.replace("null(", "").replace(")", "");
        Callback callback = new Gson().fromJson(res, Callback.class);
        if (callback == null || callback.getRes().equals("0") || callback.getData() == null || callback.getData().getFee() == null || callback.getData().getFee().length() == 0 || callback.getData().getOpenid() == null || callback.getData().getOpenid().length() == 0) {
            log.error("订单金额异常或获取用户openid异常，orderId为：{}", orderId);
            return null;
        }
        OrderInfo oi = new OrderInfo();
        oi.setOrderId(orderId);
        oi.setOpenid(callback.getData().getOpenid());
        oi.setFee(Integer.valueOf(callback.getData().getFee()));
        return oi;
    }

    public static String orderParamsXmlBuild(OrderInfo orderInfo, String ip) {
        String xml = null;
        OrderInitParams params = new OrderInitParams();
        params.setAppid(GlobalConfig.APPID);
        params.setMchid(GlobalConfig.MCHID);
        params.setNonceStr(WXPayUtil.generateNonceStr());
        params.setBody(orderInfo.getOrderDesc());
        params.setOpenid(orderInfo.getOpenid());
//        params.setTotalFee(String.valueOf(orderInfo.getFee()));
        params.setTotalFee(1 + "");
        params.setSpbillCreateIp(ip);
        params.setOutTradeNo(orderInfo.getOrderId());
        params.setNotifyUrl(GlobalConfig.PAY_NOTIFY_ADDR);
        params.setTradeType(GlobalConfig.TRADE_TYPE_GZHZF);
        Map<String, String> map = params.getFieldMap();
        try {
            xml = WXPayUtil.generateSignedXml(map, GlobalConfig.KEY);
        } catch (Exception e) {
            log.error("xml数据包生成异常，原因是：", e.getMessage());
        }
        return xml;
    }

    public static String getAccessToken(String appid, String app_secret) {
        String reqUrl = GlobalConfig.ACCESS_TOKEN_API.replace("{APPID}", appid).replace("{APP_SECRET}", app_secret);
        log.info("准备请求获取access_token接口，地址为：{}", reqUrl);
        String callback = "";
        try {
            callback = HttpUtil.get(reqUrl);
        } catch (Exception e) {
            log.error("get请求发起失败，原因是：{}", e.getMessage());
            return null;
        }
        log.info("请求完成，返回值为：{}", callback);
        AccessTokenRes ats;
        try {
            ats = new Gson().fromJson(callback, AccessTokenRes.class);
        } catch (Exception e) {
            log.error("解析access_token返回值异常，原因是：{}", e.getMessage());
            return null;
        }
        if (ats == null || ats.getAccess_token() == null || ats.getAccess_token().length() == 0)
            return null;
        return ats.getAccess_token();
    }

    public static WechatUserInfoRes getUserInfo(String access_token, String code) {
        String reqUrl = GlobalConfig.WECHAT_USER_INFO_API.replace("{ACCESS_TOKNE}", access_token).replace("{CODE}", "code");
        log.info("准备请求拉取用户信息接口，地址为：{}", reqUrl);
        String callback = "";
        try {
            callback = HttpUtil.get(reqUrl);
        } catch (Exception e) {
            log.info("get请求发起失败，原因是：{}", e.getMessage());
            return null;
        }
        log.info("请求用户信息接口完成，返回值为：{}", callback);
        WechatUserInfoRes wuir;
        try {
            wuir = new Gson().fromJson(callback, WechatUserInfoRes.class);
        } catch (Exception e) {
            log.error("解析微信用户信息失败，原因是：{}", e.getMessage());
            return null;
        }
        if (wuir.getOpenid() == null)
            return null;
        return wuir;
    }

    public static boolean wechatPayResRefresh(PassiveOrderPayRes wpr) {
        return wpr != null && WECHAT_PAY_RES_REGET.offerLast(wpr);
    }

    public static PassiveOrderPayRes getReflashMsg() {
        try {
            return WECHAT_PAY_RES_REGET.takeFirst();
        } catch (InterruptedException e) {
            return null;
        }
    }

    public static boolean wechatPayResNotify(InitiativeOrderPayRes iop) {
        return iop != null && NOTIFY_QUEUE.offerLast(iop);
    }

    public static InitiativeOrderPayRes getNotifyMsg() {
        try {
            return NOTIFY_QUEUE.takeFirst();
        } catch (InterruptedException e) {
            return null;
        }
    }

    public static InitiativeOrderPayRes getOrderPayRes(OrderQueryParam param) {
        String reqUrl = GlobalConfig.GET_ORDER_PAY_RESULT_API;
        String postbody = GlobalConfig.GET_ORDER_PAY_RESULT_POSTBODY.replace("{APPID}", param.getAppid()).replace("{MCH_ID}", param.getMchId()).replace("{NONCE_STR}", param.getNonceStr()).replace("{OUT_TRADE_NO}", param.getOutTradeNo()).replace("{SIGN}", param.getSign());
        String callback;
        log.info("发起查询微信支付结果的请求：请求url为：{}，请求参数为：{}", reqUrl, postbody);
        try {
            callback = HttpUtil.post(reqUrl, postbody);
        } catch (Exception e) {
            log.error("发起post请求失败，原因是：{}", e.getMessage());
            return null;
        }
        log.info("请求完成，返回值为：{}", callback);
        InitiativeOrderPayRes iop = XstreamUtil.Xml2Bean(callback, new InitiativeOrderPayRes());
        System.out.println(iop);
        return iop;
    }
}