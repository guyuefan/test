package com.uniubi.visitor.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * http连接池
 *
 * @author zqp
 */
public class HttpClientPools {

    private static final Logger logger = LoggerFactory.getLogger(com.uniubi.visitor.common.util.HttpClientPools.class);

    private HttpClientPools() {
    }

    private static PoolingHttpClientConnectionManager poolConnManager = null;

    private static CloseableHttpClient httpClient;

    static {
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslref = new SSLConnectionSocketFactory(builder.build());
            //配置同时支持 HTTP 和 HTPPS
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslref).build();
            // 初始化连接管理器
            poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            //同时最多连接数
            poolConnManager.setMaxTotal(50);
            // 设置最大路由
            poolConnManager.setDefaultMaxPerRoute(40);
            // MaxtTotal和DefaultMaxPerRoute的区别：
            // 1、MaxtTotal是整个池子的大小；
            // 2、DefaultMaxPerRoute是根据连接到的主机对MaxTotal的一个细分；比如：
            // MaxtTotal=400 DefaultMaxPerRoute=200
            // 而我只连接到http://www.abc.com时，到这个主机的并发最多只有200；而不是400；
            httpClient = getConnection();
        } catch (Exception e) {
            logger.error("HttpClientPools init error:", e);
        }
    }

    /**
     * 获取连接
     * <br><b>作者： zhangqp</b>
     * <br>创建时间：2020年8月12日 下午3:59:43
     *
     * @return CloseableHttpClient
     * @since 1.0
     */
    private static CloseableHttpClient getConnection() {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        return HttpClients.custom()
                // 设置连接池管理
                .setConnectionManager(poolConnManager).setDefaultRequestConfig(config)
                // 设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(2, false)).build();
    }


    /**
     * http post方法
     * 处理 jsonData请求类型
     * <br><b>作者： zhangqp</b>
     * <br>创建时间：2020年8月12日 下午3:46:39
     *
     * @param uri      路径
     * @param jsonData json数据
     * @return map
     * @since 1.0
     */
    public static Map<String, Object> postJson(String uri, String jsonData) {
        HttpPost httpPost = new HttpPost(uri);
        return doBusinessPost(httpPost, jsonData);
    }

    /**
     * http post方法
     * 处理 jsonData请求类型
     * <br><b>作者： zhangqp</b>
     * <br>创建时间：2020年8月12日 下午3:46:39
     *
     * @param uri      路径
     * @param jsonData json数据
     * @return map
     * @since 1.0
     */
    public static Map<String, Object> postJsonByToken(String uri, String jsonData, String token) {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("token", token);
        return doBusinessPost(httpPost, jsonData);
    }


    private static Map<String, Object> doBusinessPost(HttpPost httpPost, String jsonData) {
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        StringEntity se = new StringEntity(jsonData, "UTF-8");
        httpPost.setEntity(se);
        CloseableHttpResponse response = null;
        Map<String, Object> backMap = new HashMap<>(6);
        try {
            response = httpClient.execute(httpPost);
            backMap = phaseResponseBackMap(response);
        } catch (Exception e) {
            logger.error("HttpClientPools postJson error:", e);
        } finally {
            closeResource(response);
        }
        return backMap;
    }


    /**
     * httpGet方式
     *
     * @param url 请求地址
     * @return Map
     */
    public static Map<String, Object> get(String url, String token) {
        HttpRequestBase http = new HttpGet(url);
        if (!StringUtils.isBlank(token)) {
            http.addHeader("Authorization", token);
        }
        Map<String, Object> backMap = new HashMap<>(6);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(http);
            backMap = phaseResponseBackMap(response);
            return backMap;
        } catch (IOException e) {
            return backMap;
        } finally {
            closeResource(response);
        }
    }

    private static Map<String, Object> phaseResponseBackMap(CloseableHttpResponse response) throws IOException {
        Map<String, Object> backMap = new HashMap<>(6);
        int code = response.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(response.getEntity());
        if (code == HttpStatus.SC_OK) {
            backMap = JSON.parseObject(result, HashMap.class);
        }
        return backMap;
    }


    /**
     * 关闭资源
     * <br><b>作者： zhangqp</b>
     * <br>创建时间：2020年8月12日 下午4:00:00
     *
     * @param response 请求资源
     * @since 1.0
     */
    private static void closeResource(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                logger.error("HttpClientPools closeResource error:", e);
            }
        }
    }


}
