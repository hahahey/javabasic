package com.hahahey.Thread.selltickets;

public class Main {
    public static void main(String[] args) {
        MutliThread mutliThread = new MutliThread();
        Thread A = new ThreadA(mutliThread);
        Thread B = new ThreadA(mutliThread);
        Thread C = new ThreadA(mutliThread);

        A.start();
        B.start();
        C.start();
    }
}
