package com.nirvana.travel.me.base.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author arainliu
 * @date 2021/10/26
 */
public class ThreadPoolTest {

  private static final ThreadPoolExecutor executors = new ThreadPoolExecutor(10, 10,
    0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

  public static void main(String[] args) {
    executors.execute(() -> doWork());

    executors.setCorePoolSize(20);
  }

  public static void doWork() {
    System.out.println("dowork....");
  }

}
