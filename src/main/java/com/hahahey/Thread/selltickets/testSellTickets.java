package com.hahahey.Thread.selltickets;

public class testSellTickets {
    public static void main(String[] args) {

        //同步代码块实现线程安全
        //SellTickets st = new SellTickets();

        SellTickets2 st = new SellTickets2();
        new Thread(st).start();
        new Thread(st).start();
        new Thread(st).start();

    }
}
