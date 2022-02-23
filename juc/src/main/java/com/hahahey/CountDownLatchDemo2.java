package com.hahahey;

import com.beust.jcommander.internal.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author hahahey
 * @date 2021/7/23 17:00
 * @description:
 */
public class CountDownLatchDemo2 {

    static ThreadPoolExecutor executor;

    static {
        executor = new ThreadPoolExecutor(
                3,
                5,
                100,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    public static void asyncExecute(List<CovertTask> covertTasks) {
        CountDownLatch countDownLatch = new CountDownLatch(covertTasks.size());

        for (CovertTask covertTask : covertTasks) {
            covertTask.setCountDown(countDownLatch);
            executor.execute(covertTask);
        }
        try {
            countDownLatch.await();
            covertTasks.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //使用五个线程去读取文件数据，然后再异步执行
    public static void main(String[] args) throws IOException {

        LineIterator lineIterator = FileUtils.lineIterator(new File("F:\\aaa.txt"));

        List<String> list = Lists.newArrayList();
        List<CovertTask> taskLists = Lists.newArrayList();
        while (lineIterator.hasNext()) {
            String str = lineIterator.nextLine();
            list.add(str);
            //将10条数据封装为一个task执行
            if (list.size() == 10) {
                taskLists.add(new CovertTask(Lists.newArrayList(list)));
                list.clear();
            }
            if (taskLists.size() == 5) {
                //交由异步任务执行
                asyncExecute(taskLists);

            }
        }
        //最后批次为满足条件的数据也需要被处理
        taskLists.add(new CovertTask(Lists.newArrayList(list)));
        asyncExecute(taskLists);

        executor.shutdown();
    }
}

class CovertTask extends Thread {
    private final List<String> list;
    private CountDownLatch countDownLatch;

    CovertTask(List<String> list) {
        this.list = list;
    }

    public void setCountDown(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (String s : list) {
            System.out.println(Thread.currentThread().getName() + "  " +s);
        }
        countDownLatch.countDown();
    }
}