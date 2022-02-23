package com.hahahey.Thread.selltickets;


/**
 * synchronized 方法实现线程安全
 *
 *
 */
public class SellTickets2 implements Runnable{

    private int ticket = 100;
    Boolean flag = true;

    public void run() {
        sellTickets();
    }



    //线程安全的方法，synchronized的方法相当于将一个synchronized代码块的开始和方法的开始一起，结束和方法的结束一起
    //它的锁对象就是this

    public synchronized void sellTickets(){
        while (flag) {
            if (ticket <= 0) {
                System.out.println("票已卖完=========== 退出");
                flag = false;
                return;
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
