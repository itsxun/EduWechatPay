package xin.fallen.EduWechatPay.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Author: Fallen
 * Date: 2017/8/9
 * Time: 10:06
 * Usage:被动接受的微信支付通知
 */
@XStreamAlias("xml")
public class PassiveOrderPayRes {
    @XStreamAsAttribute
    @XStreamAlias("return_code")
    private String returnCode;

    @XStreamAsAttribute
    @XStreamAlias("return_msg")
    private String return_msg;

    @XStreamAsAttribute
    @XStreamAlias("appid")
    private String appid;

    @XStreamAsAttribute
    @XStreamAlias("mch_id")
    private String mchId;

    @XStreamAsAttribute
    @XStreamAlias("device_info")
    private String deviceInfo;

    @XStreamAsAttribute
    @XStreamAlias("nonce_str")
    private String nonceStr;

    @XStreamAsAttribute
    @XStreamAlias("sign")
    private String sign;

    @XStreamAsAttribute
    @XStreamAlias("sign_type")
    private String signType;

    @XStreamAsAttribute
    @XStreamAlias("result_code")
    private String resultCode;

    @XStreamAsAttribute
    @XStreamAlias("err_code")
    private String errCode;

    @XStreamAsAttribute
    @XStreamAlias("err_code_des")
    private String errCodeDes;

    @XStreamAsAttribute
    @XStreamAlias("openid")
    private String openid;

    @XStreamAsAttribute
    @XStreamAlias("is_subscribe")
    private String isSubscribe;

    @XStreamAsAttribute
    @XStreamAlias("trade_type")
    private String tradeType;

    @XStreamAsAttribute
    @XStreamAlias("bank_type")
    private String bankType;

    @XStreamAsAttribute
    @XStreamAlias("total_fee")
    private String totalFee;

    @XStreamAsAttribute
    @XStreamAlias("settlement_total_fee")
    private String settlementTotalFee;

    @XStreamAsAttribute
    @XStreamAlias("fee_type")
    private String feeType;

    @XStreamAsAttribute
    @XStreamAlias("cash_fee")
    private String cashFee;

    @XStreamAsAttribute
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;

    @XStreamAsAttribute
    @XStreamAlias("coupon_fee")
    private String couponFee;

    @XStreamAsAttribute
    @XStreamAlias("coupon_count")
    private String couponCount;

    @XStreamAsAttribute
    @XStreamAlias("coupon_type_$n")
    private String couponYype$n;

    @XStreamAsAttribute
    @XStreamAlias("coupon_id_$n")
    private String couponId$n;

    @XStreamAsAttribute
    @XStreamAlias("coupon_fee_$n")
    private String couponFee$n;

    @XStreamAsAttribute
    @XStreamAlias("transaction_id")
    private String transactionId; //微信支付订单号

    @XStreamAsAttribute
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAsAttribute
    @XStreamAlias("attach")
    private String attach;

    @XStreamAsAttribute
    @XStreamAlias("time_end")
    private String timeEnd;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
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

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(String settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public String getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(String couponFee) {
        this.couponFee = couponFee;
    }

    public String getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(String couponCount) {
        this.couponCount = couponCount;
    }

    public String getCouponYype$n() {
        return couponYype$n;
    }

    public void setCouponYype$n(String couponYype$n) {
        this.couponYype$n = couponYype$n;
    }

    public String getCouponId$n() {
        return couponId$n;
    }

    public void setCouponId$n(String couponId$n) {
        this.couponId$n = couponId$n;
    }

    public String getCouponFee$n() {
        return couponFee$n;
    }

    public void setCouponFee$n(String couponFee$n) {
        this.couponFee$n = couponFee$n;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "PassiveOrderPayRes{" +
                "returnCode='" + returnCode + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", appid='" + appid + '\'' +
                ", mchId='" + mchId + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", openid='" + openid + '\'' +
                ", isSubscribe='" + isSubscribe + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", bankType='" + bankType + '\'' +
                ", totalFee='" + totalFee + '\'' +
                ", settlementTotalFee='" + settlementTotalFee + '\'' +
                ", feeType='" + feeType + '\'' +
                ", cashFee='" + cashFee + '\'' +
                ", cashFeeType='" + cashFeeType + '\'' +
                ", couponFee='" + couponFee + '\'' +
                ", couponCount='" + couponCount + '\'' +
                ", couponYype$n='" + couponYype$n + '\'' +
                ", couponId$n='" + couponId$n + '\'' +
                ", couponFee$n='" + couponFee$n + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", attach='" + attach + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
