package com.hahahey.Thread;


/**
 * 龟兔赛跑案例
 * 1: 赛道长度为30M
 * 2: 兔子和乌龟每跑完10M就输出一次结果
 * 3: 兔子速度是10M/s 每跑完10M就休息10s  乌龟速度是1M/s 每跑完10M休息1s
 */


public class RabbitAndTortoiseRun {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        rabbit.start();
        tortoise.start();

    }
}


class Rabbit extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Rabbit run " + i + " metters");
            if (i % 10 == 0) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (i != 30)
                    System.out.println("Rabbit   remain " + (30 - i) + " metters!!!");

                if (i == 30)
                    System.out.println("Rabbit arrive!!!");

            }
        }

    }
}

class Tortoise extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                // 1m/s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tortoise run " + i + " metters");
            if (i % 10 == 0) {
                try {
                    if (i != 30)
                        System.out.println("Tortoise remain " + (30 - i) + " metters!!!");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i == 30)
                System.out.println("Tortoise arrive!!!");

        }
    }
}