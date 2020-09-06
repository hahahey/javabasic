package com.hahahey.Thread;

public class ImplementsRunnableInterface implements Runnable {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----------" + i);
        }
    }
}
