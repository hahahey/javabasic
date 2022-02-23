package com.hahahey;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hahahey
 * @date 2021/5/24 0:33
 * @description:
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new MyThread());
        //对于同一个FutureTask对象，即使开启多个线程，也只会是执行一次
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        System.out.println("执行完了主线程");
        try {
           // get()方法是一个阻塞方法
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("执行了callable接口");
        return 1024;
    }
}
