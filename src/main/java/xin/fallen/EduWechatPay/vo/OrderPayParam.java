package xin.fallen.EduWechatPay.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Fallen
 * Date: 2017/8/8
 * Time: 17:09
 * Usage:
 */
public class OrderPayParam {
    private String appId;
    private String timeStamp;
    private String nonceStr;
    private String pack;
    private String signType;
    private String paySign;

    public Map<String, String> getFieldMap() {
        Map<String, String> map = new HashMap<>(OrderPayParam.class.getDeclaredFields().length);
        map.put("appId", appId);
        map.put("timeStamp", timeStamp);
        map.put("nonceStr", nonceStr);
        map.put("package", pack);
        map.put("signType", signType);
        return map;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = "prepay_id=" + pack;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    @Override
    public String toString() {
        return "OrderPayParam{" +
                "appId='" + appId + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", pack='" + pack + '\'' +
                ", signType='" + signType + '\'' +
                ", paySign='" + paySign + '\'' +
                '}';
    }
}
