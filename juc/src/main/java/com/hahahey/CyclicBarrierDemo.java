package com.hahahey;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hahahey
 * @date 2021/5/24 17:36
 * @description:
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        // CyclicBarrier 与 CountDownLatch 正好相反，当线程达到指定个数后，才会执行指定方法
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println(Thread.currentThread().getName() + "-----------召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            final int temp = i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+ "\t" + temp + "  颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }




    }
}
