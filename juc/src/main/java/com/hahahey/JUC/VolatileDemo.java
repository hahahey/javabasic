package com.hahahey.JUC;

class MyNumber{
   volatile int number = 10;
    void add(){
        number = 1000;
    }
}

/**
 * vloatile 使保证了可见性  当线程在工作内存中修改了 主内存中的共享变量时，会通知其他线程 该共享变量已修改
 *
 *
 */

public class VolatileDemo {
    public static void main(String[] args) {
        MyNumber number = new MyNumber();
        new Thread(() -> {
            System.out.println("-------------------------");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number.add();
            System.out.println(Thread.currentThread().getName() + "----" + number.number);
        },"AAA").start();

        while (number.number == 10){
            // AAA线程虽然已经修改了number，但是main线程中的number未通知，也就是未改变，因此main线程一直在等待中
            //需要一种通知机制来通知main线程，从而跳出while
        }
        System.out.println(Thread.currentThread().getName() + "----" + number.number);

    }
}
