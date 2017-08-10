package xin.fallen.EduWechatPay.vo;

/**
 * Author: fallen
 * Date: 17-2-12
 * Time: 下午1:28
 * Usage:
 */
public class JsonResult {
    private String res;
    private String msg;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}