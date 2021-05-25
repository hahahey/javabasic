package com.hahahey.Thread;


/**
 * 两个线程交替打印AB
 **/
public class PrintAB {

    public static  void main(String[] args) {

        final Object obj = new Object();

        new A(obj).start();
        new B(obj).start();

    }
}

class A extends Thread {
    private final Object obj;

    public A(Object obj) {
        this.obj = obj;
    }


    @Override
    public  void run() {
        for (int i = 0; i < 500; i++) {

            synchronized (obj){
                System.out.println(Thread.currentThread().getName() + " 打印A");
                obj.notifyAll();
                try {
                    System.out.println(Thread.currentThread().getName() + " 开始阻塞");
                    //让当前线程进入等待状态，并释放锁
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.notifyAll();

                System.out.println(Thread.currentThread().getName() + " 开始唤醒其他线程");
            }

            System.out.println(Thread.currentThread().getName() + "---" + i);

        }
        }
    }


class B extends Thread {
    private final Object obj;

    public B(Object obj) {
        this.obj = obj;
    }

    @Override
    public  void run() {
        for (int i = 0; i < 500; i++) {
            synchronized (obj){
                System.out.println(Thread.currentThread().getName() + " 打印B");
                obj.notifyAll();
                try {
                    System.out.println(Thread.currentThread().getName() + " 开始阻塞");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.notifyAll();
                System.out.println(Thread.currentThread().getName() + " 开始唤醒其他线程");
            }
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}