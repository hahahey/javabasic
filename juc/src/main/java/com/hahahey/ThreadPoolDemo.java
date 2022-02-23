package com.hahahey;

/**
 * @author hahahey
 * @date 2021/5/25 16:10
 * @description:
 */

import java.util.concurrent.*;

/**
 * 线程池的优势
 * 线程池做的工作主要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，
 * 如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行
 * 它的主要特点为：线程复用；控制最大并发数；管理线程
 * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗
 * 第二：提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行
 * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控
 * newFixedThreadPool   指定线程数
 * newSingleThreadPool  单一线程数
 * newCachedThreadPool  可扩展的线程数
 * <p>
 * 线程池参数
 * 1.corePoolSize:线程池中的常驻核心线程数
 * 2.maximumPoolSize:线程池中能够容纳同时执行的最大线程数，此值必须大于等于1
 * 3.keepAliveTime:多余的空闲线程的存活时间，当前池中线程数量超过corePoolSize时，当空闲时间达到keepAliveTime时，多余线程会被销毁直到只剩下corePoolSize个线程为止
 * 4.unit:keepAliveTime的单位
 * 5.workQueue:任务队列，被提交但尚未被执行的任务
 * 6.threadFactory:表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认的即可
 * 7.handle:拒绝策略，表示当队列满了，并且工作线程大于等于线程池的最大线程数(maximumPoolSize)时如何来拒绝请求执行的runnable的策略
 * new ThreadPoolExecutor.AbortPolicy()           (默认)直接抛出RejectedExecutionException异常阻止系统正常运行
 * new ThreadPoolExecutor.CallerRunsPolicy()      "调用者运行"一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量
 * new ThreadPoolExecutor.DiscardPolicy()         该策略默默地丢弃无法处理的任务，不予任何处理也不抛出异常。如果允许任务丢失，这是最好的一种策略
 * new ThreadPoolExecutor.DiscardOldestPolicy()   抛弃队列中等待最久的任务，然后把当前任务加入到队列中尝试再次提交当前任务
 * 问题：工作中哪个创建线程池的方法用的多？
 * 答：一个都不用，工作中使用自定义的，是因为Fixed和Single的队列长度是Integer.max，cached的maximum参数是Integer.max 会报oom异常
 * 问题：一般线程参数怎么设置的？
 * 答：获取机器的逻辑核数+1或者+2  Runtime.getRuntime().availableProcessors()
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            for (int i = 0; i < 9; i++) {
                executorService.execute(new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t开始运行");
                }, String.valueOf(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
