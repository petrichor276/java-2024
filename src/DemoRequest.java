import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

class HttpRequestsDemo{
    // 1. 创建HttpClient实例
    public static CloseableHttpClient httpClient = HttpClients.createDefault();
    public static void getTest() throws IOException{

        // 2. 创建GET请求方法实例
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        // 3. 调用HttpClient实例来执行GET请求方法，得到response
        CloseableHttpResponse response = httpClient.execute(httpGet);
        // 4. 读response，判断是否访问成功 2xx表示 成功。
        int status = response.getStatusLine().getStatusCode();
        System.out.println(status);
        if (status >= 200 && status < 300) {
            // 调用response.getEntity()时，它会返回一个HttpEntity对象，你可以通过这个对象来访问和处理HTTP响应的实体内容
            HttpEntity entity = response.getEntity();
            System.out.println(response);
            System.out.println("=======================");
            String html = EntityUtils.toString(entity, "utf-8");
            System.out.println(html);
        } else {
            throw new ClientProtocolException("Unexpected response status: " +
                    status);
        }
        // 5. 释放连接
        response.close();
        httpClient.close();
    }
    // 重写响应
    public static void getText1() throws IOException{
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        ResponseHandler<String> responseHandler = new ResponseHandler<String>()
        {
            @Override
            public String handleResponse(HttpResponse httpResponse) throws
                    ClientProtocolException, IOException {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    return EntityUtils.toString(httpResponse.getEntity());
                } else {
                    throw new IOException("Unexpected response status: " +
                            status);
                }
            }
        };
        try {
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //构造查询参数
    public static void getText2() throws IOException{
        String baseurl = "https://wzzdg.sun0769.com/political/index/politicsNewest";
        try {
            URIBuilder urlBuilder = new URIBuilder(baseurl);

            //添加查询参数
            urlBuilder.setParameter("id", "1")
                    .setParameter("page", "1");
            URI url = urlBuilder.build();
            HttpGet httpGet = new HttpGet(url);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse httpResponse) throws
                            ClientProtocolException, IOException {
                    int status = httpResponse.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        return EntityUtils.toString(httpResponse.getEntity());
                    } else {
                        throw new IOException("Unexpected response status: " +
                                status);
                    }
                }
            };
            // 重写响应提取
            try {
                String responseBody = httpClient.execute(httpGet, responseHandler);
                System.out.println(responseBody);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    // post方法编写
    public static void postText() throws IOException {
        // 2. 创建HttpPost实例
        HttpPost httpPost = new HttpPost("http://httpbin.org/post");
        httpPost.setEntity(new StringEntity("this is Post"));
// 3. 调用HttpClient实例来执行HttpPost实例
        CloseableHttpResponse response = httpClient.execute(httpPost);
// 4. 读 response
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            System.out.println(response);
            System.out.println("===================");
            String html = EntityUtils.toString(entity);
            System.out.println(html);
        } else {
            throw new ClientProtocolException("Unexpected response status: " +
                    status);
        }
// 5. 释放连接
        response.close();
        httpClient.close();
    }

    // post第一种形式 表单是字典格式
    public static void postFromText() throws IOException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("column", "szse_gem_latest"));
        params.add(new BasicNameValuePair("pageNum", "1"));
        params.add(new BasicNameValuePair("pageSize", "30"));
        params.add(new BasicNameValuePair("sortName", ""));
        params.add(new BasicNameValuePair("sortType", ""));
        params.add(new BasicNameValuePair("clusterFlag", "true"));

        // 创建实例
        HttpPost httpPost = new HttpPost("http://www.cninfo.com.cn/new/disclosure");
        // 设置头部
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");

        // 发请求 提取响应
        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 获取响应 提取内容
        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(result);

        // 关闭连接
        response.close();
        httpClient.close();
    }

    // POST第二种形式 表单是json格式
    public static void postJsonText() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":30}";
        HttpPost httpPost = new HttpPost("http://httpbin.org/post");
        httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        httpPost.setEntity(new StringEntity(json, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            System.out.println(response);
            System.out.println("===================");
            String html = EntityUtils.toString(entity);
            System.out.println(html);
        } else {
            throw new ClientProtocolException("Unexpected response status: " +
                    status);
        }
// 5. 释放连接
        response.close();
        httpClient.close();
    }
}
public class DemoRequest {
    public static void main(String[] args) throws IOException {
//        HttpRequestsDemo.getText1();
//        HttpRequestsDemo.getText2();
//        HttpRequestsDemo.postText();

//        HttpRequestsDemo.postFromText();
        HttpRequestsDemo.postJsonText();
    }

}
