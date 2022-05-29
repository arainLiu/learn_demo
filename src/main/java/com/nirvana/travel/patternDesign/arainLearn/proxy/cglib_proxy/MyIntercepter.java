package com.nirvana.travel.patternDesign.arainLearn.proxy.cglib_proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author arainliu
 * @date 2021/5/15
 */
public class MyIntercepter implements MethodInterceptor {

  @Override
  public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy)
    throws Throwable {

    System.out.println("before 代理类执行");
    Object res = methodProxy.invokeSuper(proxy, objects);//指定代理增强的拦截器类
    System.out.println("after 代理类执行");

    return res;
  }
}
