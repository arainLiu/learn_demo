package com.nirvana.travel.patternDesign.arainLearn.proxy.static_proxy;

/**
 * @author arainliu
 * @date 2021/5/15
 */
public class SellMain {

  public static void main(String[] args) {
    UsbSell sell = new TaobaoProxySell();
    System.out.println("price:" + sell.sell(15));
    System.out.println("price:" + sell.sell(30));
    System.out.println("price:" + sell.sell(1));
  }
}
