package com.nirvana.travel.javabase.jvm.threadpool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author arainliu
 * @date 2021/5/8
 */
public class Test1 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    executorService.execute(()-> System.out.println("测试单个线程池"));
    Future<?> future = executorService.submit(() -> "测试单个线程池");
    System.out.println(future.get());

    ThreadGroup mainThreadGroup=Thread.currentThread().getThreadGroup();
    ThreadGroup systenThreadGroup=mainThreadGroup.getParent();
    System.out.println("systenThreadGroup name = "+systenThreadGroup.getName());
    System.out.println("mainThreadGroup name = "+mainThreadGroup.getName());

    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
    ScheduledFuture<String> schedule = scheduledThreadPool
      .schedule(() -> "test schedule", 5, TimeUnit.SECONDS);
    System.out.println(schedule.get());
  }
}
