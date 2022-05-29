package com.nirvana.travel.me.patternDesign.create.factoryMethod;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class Sweater implements Clothes {

  @Override
  public void make() {
    System.out.println("生产一件毛衣");
  }
}
