package com.hahahey.future;

import java.util.concurrent.TimeUnit;

/**
 * @author hahahey
 * @date 2022-04-15 0:21
 */
public class Client {

    //提供获取方法
    public Data request(String dataStr) {
        final FutureData futureData = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(dataStr);
                futureData.setData(realData);
            }
        }.start();
        return futureData;
    }


    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("hello");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getdata");
        System.out.println(data.getData());

    }

}
