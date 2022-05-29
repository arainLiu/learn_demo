package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public class Woman extends Human {

  public Woman() {
    System.out.println("女娲开始造女人");
  }

  @Override
  public String toString() {
    return "Woman{} " + super.toString();
  }
}
