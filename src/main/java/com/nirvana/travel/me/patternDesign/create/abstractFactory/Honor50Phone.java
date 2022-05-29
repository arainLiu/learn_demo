package com.nirvana.travel.me.patternDesign.create.abstractFactory;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class Honor50Phone implements IPhone {

  @Override
  public void makePhone() {
    System.out.println("生产一部荣耀50 手机");
  }
}
