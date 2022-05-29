package com.nirvana.travel.patternDesign.arainLearn.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * 必须实现InvocationHandler接口，完成代理类的功能
 *  1.调用目标类的接口
 *  2.功能增强
 *
 * @author arainliu
 * @date 2021/5/15
 */
public class MyInvocationHandler implements InvocationHandler {

  //目标类对象
  private Object target;

  //动态代理：目标类对象是不固定的，传入对象是什么，就创建对象的代理
  public MyInvocationHandler(Object target) {
    //给目标对象赋值
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    //执行目标方法,返回值为目标对象的执行结果
    Object res = method.invoke(target, args);

    System.out.println("对目标对象进行增强");
    //对对象进行功能增强
    if (res != null) {
      Float price = (Float) res;
      res = price + 10;
    }

    //返回代理类执行结果
    return res;
  }
}
