package com.hahahey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author hahahey
 * @date 2021/5/25 23:16
 * @description:
 */
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //相当于把任务拆解成能够执行的最小单元，使用的是递归的方式去拆解的
        //(0,11) -> (1,5)(6,11) 而5-1是满足 end - begin <= VALUE(10)的

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask task = new MyTask(0, 100);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        System.out.println(submit.get());
        forkJoinPool.shutdown();
    }
}

class MyTask extends RecursiveTask<Integer> {
    private static final Integer VALUE = 10;
    private final int begin;
    private final int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - begin <= VALUE){
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        }else {
            System.out.println("------------");
            int middle = (begin + end) / 2;
            MyTask task1 = new MyTask(begin,middle);
            MyTask task2 = new MyTask(middle + 1,end);
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
         }
        return result;
    }
}