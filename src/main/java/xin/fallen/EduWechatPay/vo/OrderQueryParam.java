package xin.fallen.EduWechatPay.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Fallen
 * Date: 2017/8/9
 * Time: 9:48
 * Usage:
 */
public class OrderQueryParam {
    private String appid;
    private String mchId;
    private String outTradeNo;
    private String nonceStr;
    private String sign;
    private String signType;

    public Map<String, String> getFeildMap() {
        Map<String, String> map = new HashMap<>(this.getClass().getDeclaredFields().length);
        map.put("appid", appid);
        map.put("mch_id", mchId);
        map.put("out_trade_no", outTradeNo);
        map.put("nonce_str", nonceStr);
        map.put("sign_type", signType);
        return map;
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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    @Override
    public String toString() {
        return "OrderQueryParam{" +
                "appid='" + appid + '\'' +
                ", mchId='" + mchId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
