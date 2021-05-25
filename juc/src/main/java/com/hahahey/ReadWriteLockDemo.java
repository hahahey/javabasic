package com.hahahey;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hahahey
 * @date 2021/5/24 18:42
 * @description:
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
         /*
            1.读写操作分开后，只需要对写操作加锁，而对读操作不用加锁
            2.使用ReadWriteLock来保证读写操作的线程安全性
            ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
            读取的时候使用 readLock()
            写入的时候使用 writeLock()
          */

        MyCache myCache = new MyCache();
        //新建6个线程分别用来写入和读取数据
        //写入
        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }).start();
        }

        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }).start();
        }
    }
}


class MyCache {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private  volatile  Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {

        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  开始写入数据 " + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "  写入数据完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  开始读取数据");
            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName() + "  读取数据完成 " + res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}