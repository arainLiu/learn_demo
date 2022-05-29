package com.nirvana.travel.me.patternDesign.create.singleton.innerClass;

/**
 * @author arainliu
 * @date 2021/9/14
 */
public class Singleton_inner_class {

  private static class Instance_inner_class {
    private static Singleton_inner_class instance = new Singleton_inner_class();
  }

  private Singleton_inner_class() {
  }

  public static Singleton_inner_class getInstance() {
    return Instance_inner_class.instance;
  }

}
