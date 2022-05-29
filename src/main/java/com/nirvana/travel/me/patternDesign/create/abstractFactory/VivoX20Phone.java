package com.nirvana.travel.me.patternDesign.create.abstractFactory;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class VivoX20Phone implements IPhone {

  @Override
  public void makePhone() {
    System.out.println("生产vivo x20手机");
  }
}
