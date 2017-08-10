package xin.fallen.EduWechatPay.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Author: Fallen
 * Date: 2017/8/9
 * Time: 14:54
 * Usage:主动请求的微信支付通知
 */
@XStreamAlias("xml")
public class InitiativeOrderPayRes {

    @XStreamAsAttribute
    @XStreamAlias("return_code")
    public String returnCode;

    @XStreamAsAttribute
    @XStreamAlias("return_msg")
    public String returnMsg;

    @XStreamAsAttribute
    @XStreamAlias("appid")
    public String appid;

    @XStreamAsAttribute
    @XStreamAlias("mch_id")
    public String mchId;

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
    @XStreamAlias("device_info")
    public String deviceInfo;

    @XStreamAsAttribute
    @XStreamAlias("openid")
    public String openid;

    @XStreamAsAttribute
    @XStreamAlias("is_subscribe")
    public String isSubscribe;

    @XStreamAsAttribute
    @XStreamAlias("trade_type")
    public String tradeType;

    @XStreamAsAttribute
    @XStreamAlias("trade_state")
    public String tradeState;

    @XStreamAsAttribute
    @XStreamAlias("bank_type")
    public String bankType;

    @XStreamAsAttribute
    @XStreamAlias("total_fee")
    public String totalFee;

    @XStreamAsAttribute
    @XStreamAlias("settlement_total_fee")
    public String settlementTotalFee;

    @XStreamAsAttribute
    @XStreamAlias("fee_type")
    public String feeType;

    @XStreamAsAttribute
    @XStreamAlias("cash_fee")
    public String cashFee;

    @XStreamAsAttribute
    @XStreamAlias("cash_fee_type")
    public String cashFeeType;

    @XStreamAsAttribute
    @XStreamAlias("coupon_fee")
    public String couponFee;

    @XStreamAsAttribute
    @XStreamAlias("coupon_count")
    public String couponCount;

    @XStreamAsAttribute
    @XStreamAlias("coupon_type_$n")
    public String couponType$n;

    @XStreamAsAttribute
    @XStreamAlias("coupon_id_$n")
    public String couponId$n;

    @XStreamAsAttribute
    @XStreamAlias("coupon_fee_$n")
    public String couponFee$n;

    @XStreamAsAttribute
    @XStreamAlias("transaction_id")
    public String transactionId;

    @XStreamAsAttribute
    @XStreamAlias("out_trade_no")
    public String outTradeNo;

    @XStreamAsAttribute
    @XStreamAlias("attach")
    public String attach;

    @XStreamAsAttribute
    @XStreamAlias("time_end")
    public String timeEnd;

    @XStreamAsAttribute
    @XStreamAlias("trade_state_desc")
    public String tradeStateDesc;

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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
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

    public String getTradeState() {
        return tradeState;
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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
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

    public String getCouponType$n() {
        return couponType$n;
    }

    public void setCouponType$n(String couponType$n) {
        this.couponType$n = couponType$n;
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

    public String getTradeStateDesc() {
        return tradeStateDesc==null?"":tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    @Override
    public String toString() {
        return "InitiativeOrderPayRes{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", appid='" + appid + '\'' +
                ", mchId='" + mchId + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", openid='" + openid + '\'' +
                ", isSubscribe='" + isSubscribe + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", tradeState='" + tradeState + '\'' +
                ", bankType='" + bankType + '\'' +
                ", totalFee='" + totalFee + '\'' +
                ", settlementTotalFee='" + settlementTotalFee + '\'' +
                ", feeType='" + feeType + '\'' +
                ", cashFee='" + cashFee + '\'' +
                ", cashFeeType='" + cashFeeType + '\'' +
                ", couponFee='" + couponFee + '\'' +
                ", couponCount='" + couponCount + '\'' +
                ", couponType$n='" + couponType$n + '\'' +
                ", couponId$n='" + couponId$n + '\'' +
                ", couponFee$n='" + couponFee$n + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", attach='" + attach + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", tradeStateDesc='" + tradeStateDesc + '\'' +
                '}';
    }
}
