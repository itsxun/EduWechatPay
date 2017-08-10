package xin.fallen.EduWechatPay.vo;

/**
 * Author: Fallen
 * Date: 2017/5/4
 * Time: 11:19
 * Usage:
 */
public class Callback {
    /**
     * res : 1
     * msg : 查找成功
     * data : {"fee":"5000"}
     */

    private String res;
    private String msg;
    private DataBean data;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * fee : 5000
         */

        private String fee;

        private String openid;

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }
}
