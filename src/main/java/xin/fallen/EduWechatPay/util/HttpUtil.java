package xin.fallen.EduWechatPay.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: fallen
 * Date: 17-2-10
 * Time: 下午5:04
 * Usage:
 */
public class HttpUtil {
    public static String get(String url) throws Exception {
        String res = null;
        url = urlEncode(url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    res = EntityUtils.toString(entity, "UTF-8").trim();
                    EntityUtils.consumeQuietly(entity);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("发起HttpGet请求失败，原因是：" + e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
            }
        }
        return res;
    }

    public static String post(String url, Map<String, String> formFileds) throws Exception {
        String res = null;
        url = urlEncode(url);
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>(formFileds.size());
        for (Map.Entry<String, String> entry : formFileds.entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                res = EntityUtils.toString(entity, "UTF-8").trim();
                EntityUtils.consumeQuietly(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException("发起HttpPost请求失败，原因是：" + e.getMessage());
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
            }
        }
        return res;
    }

    public static String post(String url, String postBody) throws Exception {
        String res = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new StringEntity(postBody));
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                res = EntityUtils.toString(entity, "UTF-8").trim();
                EntityUtils.consumeQuietly(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException("发起HttpPost请求失败，原因是：" + e.getMessage());
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
            }
        }
        return res;
    }

    public static String urlEncode(String oUrl) {
        String dUrl = null;
        int pos = oUrl.indexOf("?") + 1;
        String path = oUrl.substring(0, pos);
        String param = oUrl.substring(pos);
        dUrl = param
                .replaceAll("%", "%25")
                .replaceAll("\\+", "%2b")
                .replaceAll("\\\\", "%5C")
                .replaceAll("\\|", "%7C")
                .replaceAll("#", "%23")
                .replaceAll(" ", "%20")
                .replaceAll("\\{", "%7B")
                .replaceAll("}", "%7D")
                .replaceAll("\"", "%22")
                .replaceAll(":", "%3A")
                .replaceAll(",", "%2C")
                .replaceAll("<", "%3C")
                .replaceAll(">", "%3E")
                .replaceAll("`", "%60")
                .replaceAll("\\^", "%5e");
        return path + dUrl;
    }

}
