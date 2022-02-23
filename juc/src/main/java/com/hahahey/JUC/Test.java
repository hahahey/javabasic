package com.hahahey.JUC;

import java.util.concurrent.TimeUnit;

/**
 * @author hahahey
 * @date 2021/9/14 23:06
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("main");
       Thread threada =  new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                if(i == 14){
                    System.out.println("exit " + i);
                    System.exit(1);
                }else{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        threada.start();

        try {
            threada.join();
            System.out.println("main end");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
