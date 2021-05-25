package com.hahahey;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author hahahey
 * @date 2021/5/24 17:51
 * @description:
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //信号量，构造参数初始化时指定信号量的个数，即线程能获取锁的个数，当且仅当获取到信号量也就是锁之后，线程才会继续执行，否则会等待，用于限制线程个数
        //在信号量上我们定义两种操作
        // acquire(获取) 当一个线程调用acquire操作时，它要么通过成功获取信号量(信号量减1)，要么一直等下去，直到有线程释放信号量，或超时
        // release（释放） 实际上会将信号量的值加1，然后唤醒等待的线程
        // 主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到了车位");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(Thread.currentThread().getName() + "\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }

    }
}
