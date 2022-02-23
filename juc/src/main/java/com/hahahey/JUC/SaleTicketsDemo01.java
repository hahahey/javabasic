package com.hahahey.JUC;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类 = 实例变量 + 实例方法
class Ticket {
    private int number =30;

    //可重入锁
    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try{
            if(number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第: " + (number--)+"\t 还剩下: " + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        lock.unlock();
        }

    }
}


/**
 *
 *
 * 在高内聚低耦合的前提下  线程 操作 资源类
 *
 *
 */

public class SaleTicketsDemo01 {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 30; i++) {
//                    ticket.sale();
//                }
//            }
//        },"A").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 30; i++) {
//                    ticket.sale();
//                }
//            }
//        },"B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 30; i++) {
//                    ticket.sale();
//                }
//            }
//        },"C").start();


        new Thread(() ->{for (int i = 1; i < 30; i++) ticket.sale();},"A").start();
        new Thread(() ->{for (int i = 1; i < 30; i++) ticket.sale();},"B").start();
        new Thread(() ->{for (int i = 1; i < 30; i++) ticket.sale();},"C").start();


    }

}
