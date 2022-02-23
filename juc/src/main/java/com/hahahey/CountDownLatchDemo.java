package com.hahahey;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hahahey
 * @date 2021/5/24 0:47
 * @description:
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        /**
        CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
        其他线程调用countDownLatch方法会将计数器减1（调用countDownLatch的线程不会被阻塞）
        当计数器的值为0时，因await方法阻塞的线程会被唤醒，继续执行
         */

//        for (int i = 0; i < 6; i++) {
//            new Thread(new MyThreadA()).start();
//        }
//        System.out.println("主线程运行结束");


        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 运行结束");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程运行结束");


    }
}

class MyThreadA implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t 运行结束");
    }
}