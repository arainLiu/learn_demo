package com.nirvana.travel.patternDesign.arainLearn.proxy.static_proxy;

/**
 * @author arainliu
 * @date 2021/5/15
 */
public class TaobaoProxySell implements UsbSell {

  private UsbSell usbSell = new KingUsbSell();

  @Override
  public float sell(int num) {
    float price = usbSell.sell(num);
    return price + 10;
  }
}
