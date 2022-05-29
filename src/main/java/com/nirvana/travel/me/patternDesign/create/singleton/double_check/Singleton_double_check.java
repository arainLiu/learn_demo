package com.nirvana.travel.me.patternDesign.create.singleton.double_check;

/**
 * @author arainliu
 * @date 2021/9/14
 */
public class Singleton_double_check {

  private static Singleton_double_check instance;

  private Singleton_double_check() {
  }

  public static Singleton_double_check getInstance() {
    if (instance != null) {
      return instance;
    }

    synchronized (Singleton_double_check.class) {
      if (instance == null) {
        instance = new Singleton_double_check();
      }
    }

    return instance;
  }
}
