package com.nirvana.travel.me.patternDesign.create.abstractFactory;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class TypeCEarPhone implements IEarPhone {

  @Override
  public void makeEarPhone() {
    System.out.println("生产一件 typeC接口耳机");
  }
}
