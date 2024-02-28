import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class RequestProDemo {

    public static void main(String[] args) {
        // 构造地址 包含参数 头部 请求 提取响应
        String url = "https://api.mytokenapi.com/ticker/currencylist";
        // 构造头部
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
        headers.put("Origin", "https://mytokencap.com");
        headers.put("Referer", "https://mytokencap.com/");

        long timestamp = System.currentTimeMillis();
        String code = md5s(timestamp+"9527"+String.valueOf(timestamp).substring(0,6));
        System.out.printf("code: %s\n", code);
        // 构造查询参数
        Map<String, String> params = new HashMap<>();
        params.put("page", "1");
        params.put("size","100");
        params.put("subject", "market_cap");
        params.put("currency_project_tags", "231");
        params.put("language", "en_US");
        params.put("legal_currency","USD");
        params.put("timestamp",String.valueOf(timestamp));
        params.put("code",code);
        params.put("platform","web_pc");
        params.put("v","0.1.0");
        params.put("international","1");

        // 构建查询地址
        try {
            String queryString = buildQueryString(params);
            String fullUrl = url + "?" + queryString;
            System.out.printf("fullUrl: %s\n", fullUrl);

            try {
                getTests(fullUrl, headers);
            } catch (IOException e){
                // 处理异常
                e.printStackTrace();
            }
        } catch (UnsupportedClassVersionError e){
            e.printStackTrace();}
    }

    public static String buildQueryString(Map<String, String> params) {
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            queryString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return queryString.toString();
    }
    public static String md5s(String text) {
        // md5加密算法实现
        try {
// 使用 MD5 算法创建 MessageDigest 对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
// 对更新后的数据计算哈希值，存储在 byte 数组中
            byte[] messageDigest = md5.digest(text.getBytes());
// 将 byte 数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
// 返回十六进制字符串
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getTests(String url, Map<String, String> headers) throws IOException {
        // 设置请求头
        try (CloseableHttpClient httpclient = HttpClients.createDefault()){
            handleGetRequest(httpclient, url, headers);
        }
    }


    private static void handleGetRequest(CloseableHttpClient client,String url,Map<String,String> headers) throws IOException {

        HttpGet httpGet = new HttpGet(url);
        // 设置请求头
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpGet.addHeader(entry.getKey(), entry.getValue());
        }
        // 调用HttpClient实例来执行GET请求方法，得到response
        try (CloseableHttpResponse response = client.execute(httpGet)){
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                System.out.println(response);
                System.out.println("===================");
                String body = EntityUtils.toString(entity);
                System.out.println(body);
            } else {
                throw new ClientProtocolException("Unexpected response status: " +
                        status);
            }


        }
        }}


