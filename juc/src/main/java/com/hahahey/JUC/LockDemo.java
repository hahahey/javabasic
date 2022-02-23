package com.hahahey.JUC;


import java.util.concurrent.TimeUnit;

class phone{

    public synchronized void sendMail() throws Exception{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("*****sendMail");
    }
    public synchronized void sendEMS() throws Exception{
        System.out.println("*****sendEMS");
    }
    public  void sayHello() throws Exception{
        System.out.println("*****sayHello");
    }
}

/**
 *
 *
 * 一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，其他的线程都只能等待，
 * 换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 * 锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他的synchronized方法
 *
 * 普通方法和同步锁无关
 *
 * synchronized实现同步的基础，Java中的每一个对象都可以作为锁
 * 具体表现为以下三种形式
 * 对于普通方法，锁是当前实例对象，锁的是当前对象this
 * 对于同步方法块，锁是synchronized括号里配置的对象
 * 对于静态同步方法，锁是当前类的Class对象
 *
 */








public class LockDemo {
    public static void main(String[] args) {

        phone phone = new phone();
        phone phone1 = new phone();

        new Thread(() -> {
            try {
                phone.sendMail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();


        new Thread(() -> {
            try {
                phone.sayHello();
                //phone.sendEMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();



    }
}
