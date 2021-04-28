package com.nirvana.travel.javabase.juc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/8
 */
public class HashMapTest {

  public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<>();

    int initnum = 40;
    for (int i=0;i <=15;i++) {

      map.put(String.valueOf(initnum), initnum ++);
    }


  }
}
