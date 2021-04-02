package com.hahahey.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadMain {
    public final ThreadLocal<ExecutorService> executorService = ThreadLocal.withInitial(() -> Executors.newSingleThreadExecutor());

    public Future<Integer> calculate(Integer input){
        return executorService.get().submit(() -> {
            System.out.println("计算。。。。 " + input);
            Thread.sleep(1000);
            return input * input;
        });
    }

    public static void main(String[] args) throws Exception {

//        Socket socket = new Socket("192.168.241.101", 9999);
//        SocketThread socketThread = new SocketThread(socket);
//        socketThread.send();
//
//        Thread thread = new Thread(socketThread);
//        thread.start();
//
//        System.out.println("main 线程已退出");


        ThreadMain threadMain = new ThreadMain();
        Future<Integer> calculate = threadMain.calculate(10);
//        while(!calculate.isDone()){
//            System.out.println("计算中......");
//            Thread.sleep(100);
//        }

            Integer result = calculate.get();
            System.out.println(result);



        threadMain.executorService.get().shutdown();


    }
}
