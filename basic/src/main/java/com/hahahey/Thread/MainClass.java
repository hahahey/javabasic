package com.hahahey.Thread;


/**
 * 线程：是程序执行时的一个实例，是系统进行资源分配和调度的基本单位
 * 进程：是程序执行流的最小单元，是进程中的一个实体，是被系统独立调度和分派的基本单位
 */


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 两种方式实现多线程
 * 1: 继承Thread类
 * 2: 实现Runnable接口，重写run方法
 * 3: 实现Callable接口，重写call方法
 * 4：线程池创建线程
 */

/**
 *线程周期
 * 1.创建线程对象(NEW)：指我们继承Thread类或者实现Runnable接口的线程类创建了一个Thread对象(Callable接口)
 * 2.线程就绪(Runnable)：线程对象调用了start方法，此时线程就绪，进入等待队列，可以随时被cpu选中
 * 3.线程运行(Running)：当一个处于就绪状态的线程被cpu选中，那么这个线程的代码开始运行，cpu时间片到期或者是调用阻塞类的方法或者是
 *   调用了yield方法join方法等
 * 4.阻塞状态(Blocked)：线程运行中调用了阻塞类的方法，sleep() wait() ,在阻塞状态中，线程是不会运行的，直到阻塞状态结束
 * 5.结束状态(Dead)：当线程所有的代码都执行完毕，则进入到结束状态
 *
 *
 */

/**
 * Object:
 * notify() --唤醒在该锁对象上等待的线程
 * notifyAll() --唤醒在该锁对象上等待的所有线程
 * wait() --让当前对象进入等待状态，直到其他线程调用此对象的notify 或者 notifyAll方法，来唤醒该线程进入"就绪状态"
 * wait(Long timeOut) --让当前对象进入等待状态，直到其他线程调用此对象的notify 或者 notifyAll方法 或者 超过指定的时间量，来唤醒该线程进入"就绪状态"
 *
 *
 *
 *
 **/

public class MainClass {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        // 1
//        ExtendsThreadClass thread1 = new ExtendsThreadClass();
//        thread1.start();
//
//        // 2
//        ImplementsRunnableInterface runnableInterface = new ImplementsRunnableInterface();
//        Thread thread2 = new Thread(runnableInterface);
//        thread2.start();
//
//        for (int i = 1; i <= 100; i++) {
//            System.out.println(Thread.currentThread().getName()+"==========" + i);
//        }


//        //3
//        FutureTask<String> ft = new FutureTask(new ImplementsCallableInterface());
//
//        new Thread(ft).start();
//        System.out.println("返回值" + ft.get());
//

        //4
        //返回指定线程数量的ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new ImplementsRunnableInterface());
        executorService.submit(new ImplementsRunnableInterface());
        executorService.submit(new ImplementsRunnableInterface());

        //关闭线程池
        executorService.shutdown();





    }
}
