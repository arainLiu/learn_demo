package com.nirvana.travel.me.patternDesign.create.simpleFactory;

/**
 * @author arainliu
 * @date 2021/8/26
 */
public class BMWCar implements Car {

  @Override
  public void running() {
    System.out.println("BMW car is running!");
  }
}
