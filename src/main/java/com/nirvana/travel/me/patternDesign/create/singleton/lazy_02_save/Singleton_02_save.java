package com.nirvana.travel.me.patternDesign.create.singleton.lazy_02_save;

import com.nirvana.travel.me.patternDesign.create.singleton.lazy_01.Singleton_01_lazy;

/**
 * @author arainliu
 * @date 2021/9/14
 */
public class Singleton_02_save {

  private static Singleton_02_save instance;

  private Singleton_02_save() {
  }

  //线程安全，但是锁加到方法上，所以造成资源浪费
  public static synchronized Singleton_02_save getInstance() {
    if (instance != null) {
      return instance;
    }

    instance = new Singleton_02_save();
    return instance;
  }
}
