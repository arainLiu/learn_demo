package com.nirvana.travel.me.patternDesign.create.singleton.hungry;

/**
 * @author arainliu
 * @date 2021/9/14
 */
public class Singleton_hungry_save_01 {

  private static Singleton_hungry_save_01 instance = new Singleton_hungry_save_01();

  private Singleton_hungry_save_01() {

  }

  public static Singleton_hungry_save_01 getInstance() {
    return instance;
  }
}
