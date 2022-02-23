package com.hahahey;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author hahahey
 * @date 2021/5/24 23:36
 * @description: 阻塞队列
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        //add() remove() 抛异常
        //offer() poll() 特殊值
        //put() take()   阻塞
        //offer(e,time,unit) poll(e,time,unit) 限时等待



//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("a"));
//        //使用add增加超过容量的元素时候会抛异常
//        //System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        //使用remove移除空队列时候会抛异常
//        System.out.println(blockingQueue.remove());




    }
}
