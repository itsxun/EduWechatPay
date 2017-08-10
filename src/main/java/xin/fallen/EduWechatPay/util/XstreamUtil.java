package xin.fallen.EduWechatPay.util;

import com.thoughtworks.xstream.XStream;

/**
 * Author: Fallen
 * Date: 2017/8/9
 * Time: 10:36
 * Usage:
 */
public class XstreamUtil {

    @SuppressWarnings("unchecked")
    public static <T> T Xml2Bean(String xml, T obj) {
        XStream xStream = new XStream();
        xStream.ignoreUnknownElements();
        xStream.processAnnotations(obj.getClass());
        T res;
        try {
            res = (T) xStream.fromXML(xml);
        } catch (Exception e) {
            return null;
        }
        return res;
    }
}
