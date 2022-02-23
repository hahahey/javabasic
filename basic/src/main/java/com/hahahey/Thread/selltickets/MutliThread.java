package com.hahahey.Thread.selltickets;

public class MutliThread {
    public MutliThread() {
    }

    public void print(int count) throws Exception{
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + " 开始打印");
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            Thread.sleep(2000);
        }
    }
}



