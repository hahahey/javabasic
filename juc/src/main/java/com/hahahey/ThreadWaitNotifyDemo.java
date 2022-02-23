package com.hahahey;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hahahey
 * @date 2021/5/21 15:52
 * @description: 两个线程，可以操作初始值为0的一个变量，实现一个线程对变量加1，一个线程对变量减1，实现交替，来10轮，变量初始值为0
 * <p>
 * <p>
 * 1.高内聚低耦合前提下，线程操作资源类
 * 2.判断/干活/通知
 * 3.多线程交互中，必须要防止多线程的虚假唤醒 (判断只能用while，不能用if)
 * <p>
 * 1.使用synchronized关键字同步代码，保证线程安全
 * 2.使用Lock类来保证线程安全
 */
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) throws Exception {

        //AirCondition airCondition = new AirCondition();
        AirConditionWithLock airCondition = new AirConditionWithLock();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "D").start();

    }
}


class AirCondition {
    private int number = 0;

    public synchronized void increase() throws Exception {
        //不能使用if来进行判断，原因是if不会进行条件判断直接执行代码，while会在进行一次条件判断
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }

    public synchronized void decrease() throws Exception {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
}

class AirConditionWithLock {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() throws Exception {
        lock.lock();
        try {
            //不能使用if来进行判断，原因是if不会进行条件判断直接执行代码，while会在进行一次条件判断
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrease() throws Exception {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}