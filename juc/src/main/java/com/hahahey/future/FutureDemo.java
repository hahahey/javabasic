package com.hahahey.future;

import java.util.concurrent.*;

/**
 * @author hahahey
 * @date 2022-04-14 22:39
 */
public class FutureDemo implements Callable<String> {
    @Override
    public String call() throws Exception {

        System.out.println("开始执行 callable");
        TimeUnit.SECONDS.sleep(3);
        return "hello world!";
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Future<?> submit = Executors.newFixedThreadPool(1).submit(new FutureDemo());

        TimeUnit.SECONDS.sleep(2);
        System.out.println(submit.isDone());
        System.out.println(submit.get());




    }





}
