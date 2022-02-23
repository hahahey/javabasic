package com.hahahey;

/**
 * @author hahahey
 * @date 2021/5/20 16:46
 * @description:
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目: 三个售票员  卖出  30张票
 *
 * 1.在高内聚低耦合的前提下  线程 操作(对外暴露的调用方法) 资源类
 **/
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{for (int i=0;i<=40;i++)  ticket.saleTicket();},"A").start();
        new Thread(()->{for (int i=0;i<=40;i++)  ticket.saleTicket();},"B").start();
        new Thread(()->{for (int i=0;i<=40;i++)  ticket.saleTicket();},"C").start();

    }
}


class Ticket{
    private  int tickets = 30;
    Lock lock = new ReentrantLock();
//    public synchronized void saleTicket(){
//        if(tickets > 0){
//        System.out.println(Thread.currentThread().getName() + "\t 卖出了第 " + (tickets--) + " 张票，还剩下 " +  tickets  + " 张票" );
//        }
//    }

    public  void saleTicket(){
        lock.lock();
        try {
            if(tickets > 0){
                System.out.println(Thread.currentThread().getName() + "\t 卖出了第 " + (tickets--) + " 张票，还剩下 " +  tickets  + " 张票" );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}