package xin.fallen.EduWechatPay.vo;

/**
 * Author: Fallen
 * Date: 2017/8/7
 * Time: 17:42
 * Usage:
 */
public class OrderInfo {
    private String orderId;
    private int fee;
    private String openid;
    private String orderDesc;

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId='" + orderId + '\'' +
                ", fee=" + fee +
                ", openid='" + openid + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
