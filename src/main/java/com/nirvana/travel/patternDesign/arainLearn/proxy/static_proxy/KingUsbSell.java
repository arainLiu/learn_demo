package com.nirvana.travel.patternDesign.arainLearn.proxy.static_proxy;

/**
 * @author arainliu
 * @date 2021/5/15
 */
public class KingUsbSell implements UsbSell {

  @Override
  public float sell(int num) {
    if (num > 10 && num <= 20) {
      return 80;
    }

    if (num > 20 && num <= 100) {
      return 75;
    }
    return 85;
  }
}
