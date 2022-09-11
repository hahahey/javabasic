package com.hahahey.httpclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author hahahey
 * @date 2022-09-07 23:34
 */
public class JdkHttp {
    public static void main(String[] args) throws Exception {

        //使用jdk原生的api来请求

        String urlStr = "http://www.baidu.com";

        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();

        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        //设置请求方式
        httpURLConnection.setRequestMethod("GET");

        /**
         *
         * 请求行
         * 空格
         * 请求头
         * 请求体
         */

        try (
                //获取字节输入流
                InputStream inputStream = httpURLConnection.getInputStream();
                //通过指定的编码将字节流转为字符流
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                //包装为字符缓冲流
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
