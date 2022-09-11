package com.hahahey.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author hahahey
 * @date 2022-09-07 22:47
 */
public class HttpClientDemo20 {


    private static PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

    static {
        //最大连接数  500
        connectionManager.setMaxTotal(500);
        //路由连接数 500
        connectionManager.setDefaultMaxPerRoute(500);
    }

    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(2000)
            .setConnectTimeout(2000)
            .setConnectionRequestTimeout(2000)
            .build();

    private static CloseableHttpClient getClient() {
        return HttpClients.custom().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }


    public static void main(String[] args) throws IOException {

        String url = "http://www.baidu.com";
        CloseableHttpClient client = getClient();

        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = client.execute(httpGet);

        System.out.println("返回状态码  " + response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        String s = EntityUtils.toString(entity, "UTF-8");
        System.out.println(s);


    }
}
