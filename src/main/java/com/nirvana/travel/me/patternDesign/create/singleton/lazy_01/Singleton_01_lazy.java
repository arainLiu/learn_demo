package com.nirvana.travel.me.patternDesign.create.singleton.lazy_01;

/**
 * @author arainliu
 * @date 2021/9/14
 */
public class Singleton_01_lazy {

  private static Singleton_01_lazy instance;

  private Singleton_01_lazy() {

  }


  //线程不安全
  private static Singleton_01_lazy getInstance() {
    if (instance != null)
      return instance;

    instance = new Singleton_01_lazy();
    return instance;
  }
}
