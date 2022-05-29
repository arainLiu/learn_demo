package com.nirvana.travel.patternDesign.arainLearn.proxy.cglib_proxy;


/**
 * @author arainliu
 * @date 2021/5/15
 */
public class KingUsbSell {

  public float sell(int num) {
    System.out.println("目标类中，执行sell方法");
    if (num > 10 && num <= 20) {
      return 80;
    }

    if (num > 20 && num <= 100) {
      return 75;
    }
    return 85;
  }
}
