package com.nirvana.travel.patternDesign.arainLearn.proxy.jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * @author arainliu
 * @date 2021/5/15
 */
public class MainShop {

  public static void main(String[] args) {

    //1.创建目标对象
    UsbSell usbSell = new KingUsbSell();

    //2. 创建invocationHandler对象，实现代理对象的功能
    MyInvocationHandler handler = new MyInvocationHandler(usbSell);

    //3.创建代理类对象
    UsbSell instance = (UsbSell) Proxy
      .newProxyInstance(usbSell.getClass().getClassLoader(), usbSell.getClass().getInterfaces(),
        handler);

    float price1 = instance.sell(20);
    System.out.println("price" + price1);

    float price2 = instance.sell(40);
    System.out.println("price" + price2);

    float price3 = instance.sell(1);
    System.out.println("price" + price3);

  }
}
