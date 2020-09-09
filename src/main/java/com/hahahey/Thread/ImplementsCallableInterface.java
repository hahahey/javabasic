package com.hahahey.Thread;

import java.util.concurrent.Callable;

public class ImplementsCallableInterface implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        String s = "";
        for (int i = 1; i <= 100 ; i++) {
            System.out.println("线程运行中---------" + i);
            s += "john" + i;
        }

        return s;
    }
}
