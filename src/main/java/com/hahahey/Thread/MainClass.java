package com.hahahey.Thread;


/**
 * 线程：是程序执行时的一个实例，是系统进行资源分配的基本单位
 * 进程：是程序执行流的最小单元，是进程中的一个实体，是被系统独立调度和分派的基本单位
 *
 */


/**
 * 两种方式实现多线程
 * 1: 继承Thread类
 * 2: 实现Runnable接口，重写run方法
 *
 *
 */

public class MainClass {

    //定义距离
    public static int destination = 30;

    public static void main(String[] args) {

        // 1
        ExtendsThreadClass thread1 = new ExtendsThreadClass();
        thread1.start();

        // 2
        ImplementsRunnableInterface runnableInterface = new ImplementsRunnableInterface();
        Thread thread2 = new Thread(runnableInterface);
        thread2.start();

        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+"==========" + i);
        }








    }
}
