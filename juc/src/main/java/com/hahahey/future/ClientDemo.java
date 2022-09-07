package com.hahahey.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * @author hahahey
 * @date 2022-04-14 23:29
 */
public class ClientDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureDemo futureDemo = new FutureDemo();

        ExecutorService pool = newSingleThreadExecutor();

        Future<String> submit = pool.submit(futureDemo);

        System.out.println(submit.isDone());
        System.out.println(submit.get());

        pool.shutdown();

    }
}
