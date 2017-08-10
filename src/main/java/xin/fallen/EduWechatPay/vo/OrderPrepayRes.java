package xin.fallen.EduWechatPay.vo;

import com.github.wxpay.sdk.WXPayUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import xin.fallen.EduWechatPay.config.GlobalConfig;

/**
 * Author: Fallen
 * Date: 2017/8/8
 * Time: 16:43
 * Usage:
 */
@XStreamAlias("xml")
public class OrderPrepayRes {
    @XStreamAsAttribute
    @XStreamAlias("return_code")
    private String returnCode;

    @XStreamAsAttribute
    @XStreamAlias("return_msg")
    private String returnMsg;

    @XStreamAsAttribute
    @XStreamAlias("appid")
    public String appid;

    @XStreamAsAttribute
    @XStreamAlias("mch_id")
    public String mchId;

    @XStreamAsAttribute
    @XStreamAlias("device_info")
    public String deviceInfo;

    @XStreamAsAttribute
    @XStreamAlias("nonce_str")
    public String nonceStr;

    @XStreamAsAttribute
    @XStreamAlias("sign")
    public String sign;

    @XStreamAsAttribute
    @XStreamAlias("result_code")
    public String resultCode;

    @XStreamAsAttribute
    @XStreamAlias("err_code")
    public String errCode;

    @XStreamAsAttribute
    @XStreamAlias("err_code_des")
    public String errCodeDes;

    @XStreamAsAttribute
    @XStreamAlias("trade_type")
    public String tradeType;

    @XStreamAsAttribute
    @XStreamAlias("prepay_id")
    public String prepayId;

    @XStreamAsAttribute
    @XStreamAlias("code_url")
    public String codeUrl;


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public OrderPayParam res2Param() {
        OrderPayParam orp = new OrderPayParam();
        orp.setAppId(appid);
        orp.setNonceStr(WXPayUtil.generateNonceStr());
        orp.setSignType("MD5");
        orp.setTimeStamp(String.valueOf(WXPayUtil.getCurrentTimestamp()));
        orp.setPack(prepayId);
        String sign;
        try {
            sign = WXPayUtil.generateSignature(orp.getFieldMap(), GlobalConfig.KEY);
        } catch (Exception e) {
            throw new RuntimeException("生成签名失败，原因是：" + e.getMessage());
        }
        orp.setPaySign(sign);
        return orp;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    @Override
    public String toString() {
        return "OrderPrepayRes{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", appid='" + appid + '\'' +
                ", mchId='" + mchId + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                '}';
    }
}
