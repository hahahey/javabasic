package com.hahahey.Thread.selltickets;

public class ThreadA extends Thread {
    private MutliThread mutliThread;

    public ThreadA(MutliThread mutliThread) {
        this.mutliThread = mutliThread;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.mutliThread.print((int) (Math.random() * 100));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}