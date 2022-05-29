package com.nirvana.travel.mybatis.basedemo1;

import com.nirvana.travel.mybatis.basedemo1.mapper.MainMapper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Select;

/**
 * @author arainliu
 * @date 2021/5/16
 */
public class MainTest {

  public static void main(String[] args) {
    MainMapper userMapper = (MainMapper) Proxy
      .newProxyInstance(MainTest.class.getClassLoader(), new Class<?>[]{MainMapper.class},
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Select annotation = method.getAnnotation(Select.class);
            Map<String, Object> nameArgs = buildMethodArgsMap(method, args);
            System.out.println(nameArgs);
            if (annotation != null) {
              String[] value = annotation.value();
              System.out.println(Arrays.toString(value));
            }
            return null;
          }
        });

    userMapper.getUserList(1, "xiaoming");
  }

  public static Map<String, Object> buildMethodArgsMap(Method method, Object[] args) {
    Map<String, Object> nameArgsMap = new HashMap<>();

    Parameter[] parameters = method.getParameters();
    int[] index = new int[]{0};
    Arrays.asList(parameters).forEach(param -> {
      String name = param.getName();
      System.out.println(name);
//      nameArgsMap.put(name, args[index[0]]);
      index[0]++;
    });

    return nameArgsMap;
  }


}
