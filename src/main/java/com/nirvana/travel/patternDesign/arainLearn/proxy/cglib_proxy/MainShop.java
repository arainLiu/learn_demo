package com.nirvana.travel.patternDesign.arainLearn.proxy.cglib_proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author arainliu
 * @date 2021/5/16
 */
public class MainShop {

  public static void main(String[] args) {
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
      "/Users/liupengyu/code/privateproject/nirvana-travel/src/class/cglib");
//    KingUsbSell usbSell = new KingUsbSell();
    KingUsbSell proxyInstance = getProxyInstance(KingUsbSell.class);
    float price = proxyInstance.sell(10);
    System.out.println(price);
  }

  public static <T> T getProxyInstance(Class<T> clz) {
    //构建增强器
    Enhancer enhancer = new Enhancer();
    //传入cglib动态代理回调处理类
    enhancer.setCallback(new MyIntercepter());
    //指定目标类（被代理的类）的类对象信息
    enhancer.setSuperclass(clz);
    //创建具体被代理类对象实例
    return (T) enhancer.create();
  }

}
