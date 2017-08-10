package xin.fallen.EduWechatPay.po;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Fallen
 * Date: 2017/8/7
 * Time: 10:24
 * Usage:订单生成参数
 */
public class OrderInitParams {
    //      必传
    private String appid;   //公众账号ID
    private String mchid;//商户号
    private String nonceStr;//随机字符串
    private String body;//商品描述
    private String totalFee;//标价金额
    private String spbillCreateIp;//终端ip
    private String outTradeNo;//商户订单号
    private String notifyUrl;//通知地址
    private String tradeType;//交易类型
    private String sign;//签名
    private String openid;//用户标识
    //      选传
    private String signType;//签名类型
    private String deviceInfo;//设备号
    private String detail;//商品详情
    private String attach;//附加数据
    private String feeType;//标价币种
    private String timeStart;//交易起始时间
    private String timeExpire;//交易结束时间
    private String goodsTag;//订单优惠标记
    private String productId;//商品id
    private String limiPay;//指定支付方式
    private String sceneInfo;//场景信息

    public Map<String, String> getFieldMap() {
        Map<String, String> paramMap = new HashMap<>(this.getClass().getDeclaredFields().length);
        paramMap.put("appid", appid);
        paramMap.put("mch_id", mchid);
        paramMap.put("nonce_str", nonceStr);
        paramMap.put("body", body);
        paramMap.put("total_fee", totalFee);
//        paramMap.put("spbill_create_ip", spbillCreateIp);
        paramMap.put("spbill_create_ip", "60.205.210.86");
        paramMap.put("out_trade_no", outTradeNo);
        paramMap.put("notify_url", notifyUrl);
        paramMap.put("trade_type", tradeType);
        paramMap.put("sign", sign);
        paramMap.put("openid", openid);
        return paramMap;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimiPay() {
        return limiPay;
    }

    public void setLimiPay(String limiPay) {
        this.limiPay = limiPay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    @Override
    public String toString() {
        return "OrderInitParams{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", body='" + body + '\'' +
                ", totalFee='" + totalFee + '\'' +
                ", spbillCreateIp='" + spbillCreateIp + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", detail='" + detail + '\'' +
                ", attach='" + attach + '\'' +
                ", feeType='" + feeType + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeExpire='" + timeExpire + '\'' +
                ", goodsTag='" + goodsTag + '\'' +
                ", productId='" + productId + '\'' +
                ", limiPay='" + limiPay + '\'' +
                ", openid='" + openid + '\'' +
                ", sceneInfo='" + sceneInfo + '\'' +
                '}';
    }
}
