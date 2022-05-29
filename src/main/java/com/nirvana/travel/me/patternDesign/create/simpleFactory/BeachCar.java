package com.nirvana.travel.me.patternDesign.create.simpleFactory;

/**
 * @author arainliu
 * @date 2021/8/26
 */
public class BeachCar implements Car {

  @Override
  public void running() {
    System.out.println("Benci car is running!");
  }
}
