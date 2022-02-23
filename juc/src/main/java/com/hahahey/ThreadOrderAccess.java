package com.hahahey;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hahahey
 * @date 2021/5/23 14:36
 * @description:
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {shareResource.print5(5);},"A").start();
        new Thread(() -> {shareResource.print10(5);},"B").start();
        new Thread(() -> {shareResource.print15(5);},"C").start();
    }
}

class ShareResource {
    //标志位
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5(int num) {
        lock.lock();
        try{
            while(number != 1){
                condition1.await();
            }
            for (int i = 0; i < num; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(int num) {
        lock.lock();
        try{
            while(number != 2){
                condition2.await();
            }
            for (int i = 0; i < num; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(int num) {
        lock.lock();
        try{
            while(number != 3){
                condition3.await();
            }
            for (int i = 0; i < num; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
