package xin.fallen.EduWechatPay.vo;

/**
 * Author: Fallen
 * Date: 2017/8/8
 * Time: 13:29
 * Usage:
 */
public class AccessTokenRes {

    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 7200
     */

    private String access_token;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
