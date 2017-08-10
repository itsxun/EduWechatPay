import com.github.wxpay.sdk.WXPayUtil;
import com.thoughtworks.xstream.XStream;
import xin.fallen.EduWechatPay.vo.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Fallen
 * Date: 2017/8/7
 * Time: 13:18
 * Usage:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String xml = "<xml>\n" +
                "<appid>wx613eaf094033cb8d</appid>\n" +
                "<mch_id>1485742892</mch_id>\n" +
                "<nonce_str>100d3eebe4ff4fc0ba12b8c58739c5c6</nonce_str>\n" +
                "<out_trade_no>20170809996416368</out_trade_no>\n" +
                "<sign>80A9689E0A9089DAC826C49B4ABC57AF</sign>\n" +
                "</xml>";

//        Map<String, String> map = new HashMap<>();
//        map.put("appid","wx613eaf094033cb8d");
//        map.put("mch_id","1485742892");
//        map.put("nonce_str","100d3eebe4ff4fc0ba12b8c58739c5c6");
//        map.put("out_trade_no","20170809996416368");
////        map.put("sign","F4C4FB7B632634A37B35E1D7E98BCFC8");
//        String sign=WXPayUtil.generateSignature(map,"sA05QJH5N5fw02n7yzktmvQXQfADFGFC");
//        System.out.println(sign);
        System.out.println(WXPayUtil.isSignatureValid(xml, "sA05QJH5N5fw02n7yzktmvQXQfADFGFC"));
    }
}