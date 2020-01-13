package com.superatom.javamovie.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superatom.javamovie.model.RequestParam;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestUtil {
    private static Logger logger = LoggerFactory.getLogger(RestUtil.class);

    private static HttpClient client;
    private static ObjectMapper objectMapper = new ObjectMapperForDate();
    private static RequestConfig longRequestConfig = RequestConfig.custom().setSocketTimeout(60000)
            .setConnectionRequestTimeout(60000).setConnectTimeout(15000).build();

    static {
        HttpClientBuilder builder = HttpClients.custom();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(100000);
        connManager.setDefaultMaxPerRoute(100000);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(20000)
                .setConnectTimeout(3000)
                .setSocketTimeout(20000)
                .build();
        client = builder.setConnectionManager(connManager).setDefaultRequestConfig(longRequestConfig).build();//new DefaultHttpClient(manager);
    }

    public static String get(String url) {
        HttpGet httpGet = new HttpGet(url.toString());//发送请求
        CloseableHttpResponse response = null;
        String result = "";
        try {
            response = (CloseableHttpResponse) client.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (response != null && statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();//获取结果实体
                result = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String post(String url, List<RequestParam> body){
        Map map = new HashMap();
        for (RequestParam param : body){
            map.put(param.getKey(), param.getValue());
        }
        return post(getUrl(url), map);
    }

    public static String post(String url, Map body) {
        HttpPost post = createPost(url, body);
        String ret = executeForString(post);
        return ret;
    }

    private static String getUrl(String url){
        return url + "?platform=h5&ver=4.0.0.0002&deviceid=15fmIL61d2X87X284930&model=iPhone5&channel=30006&product=1";
    }

    private static HttpPost createPost(String url, Map body) {
        HttpPost post = new HttpPost(url);
        if (body != null) {
            String content = convertMapToString(body);
            post.setHeader("Content-Type", "application/json");
            StringEntity se = new StringEntity(content, ContentType.APPLICATION_JSON);
            post.setEntity(se);
        }
        return post;
    }

    private static HttpPost createPost(String url, String content) {
        HttpPost post = new HttpPost(url);
        if (content != null) {
            StringEntity se = new StringEntity(content, ContentType.create("text/plain", Consts.UTF_8));
            post.setEntity(se);
        }
        return post;
    }

    private static String convertMapToString(Map map) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            System.out.println("json解析异常");
            e.printStackTrace();
        }
        return json;
    }

    private static String executeForString(HttpUriRequest request) {
        String ret = null;
        try {
            HttpResponse response = client.execute(request);
            HttpEntity he = response.getEntity();
            ret = EntityUtils.toString(he, "UTF-8");
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("RestUtil请求抛出异常, url={}", request.getURI());
            logger.error("RestUtil请求抛出异常", e);
        }
        return ret;
    }
}
