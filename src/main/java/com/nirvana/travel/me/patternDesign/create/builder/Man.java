package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public class Man extends Human {

  public Man() {
    System.out.println("女娲开始造男人");
  }

  @Override
  public String toString() {
    return "Man{} " + super.toString();
  }
}
