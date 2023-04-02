package com.hahahey.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author hahahey
 * @date 2022-09-09 22:37
 */
public class HttpClientDemo02 {

    @Test
    public void Test1() throws Exception {

        String url = "http://www.baidu.com";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse execute = httpClient.execute(httpGet);

        for (Header allHeader : execute.getAllHeaders()) {
            System.out.println(allHeader.getName() + " " + allHeader.getValue());
        }

    }

    @Test
    public void Test2() throws Exception{
        //String url = "https://pic3.zhimg.com/v2-58d652598269710fa67ec8d1c88d8f03_r.jpg?source=1940ef5c";
        String url = "https://bz.zzzmh.cn/index";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse execute = httpClient.execute(httpGet);

        //获取contentType类型
        HttpEntity entity = execute.getEntity();
        String value = entity.getContentType().getValue();
        //获取文件格式
        String prefix = ".jpg";
        if(value.contains(".jpg")|| value.contains("jepg")){
            prefix = ".jpg";
        }else if(value.contains("png")){
            prefix = ".jpg";
        }

        //获取文件字节流
        String savePath = "D:\\CloudMusic\\abc" + prefix;
        FileOutputStream  fileOutputStream = new FileOutputStream(savePath);

        byte[] bytes = EntityUtils.toByteArray(entity);
        fileOutputStream.write(bytes);


        fileOutputStream.close();
        EntityUtils.consume(entity);
        execute.close();
        httpClient.close();
    }

    //设置代理
    @Test
    public void Test3() throws Exception{
        String url = "http://www.baidu.com";
        CloseableHttpClient httpClient = HttpClients.createDefault();


        HttpHost httpHost = new HttpHost("103.156.15.28",8080);
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(httpHost)
                .build();



        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse execute = httpClient.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        System.out.println(EntityUtils.toString(entity));


        EntityUtils.consume(entity);
        execute.close();
        httpClient.close();
    }

    //设置连接超时和读取超时
    @Test
    public void Test4() throws Exception{
        String url = "http://www.baidu.com";
        CloseableHttpClient httpClient = HttpClients.createDefault();


         RequestConfig requestConfig = RequestConfig.custom()
                 //设置连接超时  完成tcp 3次握手时间上限
                .setConnectTimeout(3000)
                 //设置读取超时，表示从请求的网址处获得相应数据的时间间隔
                 .setSocketTimeout(3000)
                 //设置从连接池里面获取connection的超时时间
                 .setConnectionRequestTimeout(3000)
                .build();



        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse execute = httpClient.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        System.out.println(EntityUtils.toString(entity));


        EntityUtils.consume(entity);
        execute.close();
        httpClient.close();
    }


    //上传文件
    @Test
    public void Test5() throws Exception{
        String url = "http://www.baidu.com";
        CloseableHttpClient httpClient = HttpClients.createDefault();


        RequestConfig requestConfig = RequestConfig.custom()
                //设置连接超时  完成tcp 3次握手时间上限
                .setConnectTimeout(3000)
                //设置读取超时，表示从请求的网址处获得相应数据的时间间隔
                .setSocketTimeout(3000)
                //设置从连接池里面获取connection的超时时间
                .setConnectionRequestTimeout(3000)
                .build();



        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse execute = httpClient.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        System.out.println(EntityUtils.toString(entity));


        EntityUtils.consume(entity);
        execute.close();
        httpClient.close();
    }
}
