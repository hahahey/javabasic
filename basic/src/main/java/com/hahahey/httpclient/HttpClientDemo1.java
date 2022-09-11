package com.hahahey.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author hahahey
 * @date 2022-09-07 23:50
 *  httpCLient 无参请求
 */
public class HttpClientDemo1 {
    public static void main(String[] args) {

        String url = "http://www.baidu.com";

        //可关闭的httpClient客户端，相当于你打开的一个浏览器
        CloseableHttpClient httpClients = null;
        httpClients = HttpClients.createDefault();

        //构造httpGet请求
        HttpGet httpGet = new HttpGet(url);
        //可关闭的响应
        CloseableHttpResponse response = null;
        try {
            response = httpClients.execute(httpGet);
            //获取响应结果  HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现
            HttpEntity entity = response.getEntity();
            //对httpClient操作的工具类
            String result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(result);
            //确保流关闭
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {

                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClients != null) {
                try {
                    httpClients.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
