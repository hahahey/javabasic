package com.hahahey.Thread.selltickets;


/**
 *
 * sychnorized 代码块实现线程安全
 */
public class SellTickets implements Runnable {
    private int ticket = 100;

    public void run() {


        //使用同步代码块保证线程安全
        //担任锁对象的这个对象必须保证所有的线程使用的是同一个锁对象，普通方法的锁对象就是this

        synchronized (this) {
            while (true) {
                if (ticket <= 0) {
                    System.out.println("票已卖完=========== 退出");
                    break;
                }
                try {
                    Thread.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售票窗口卖出一张票——————————————————————当前剩余 " + --ticket);
            }
        }





    }
}
