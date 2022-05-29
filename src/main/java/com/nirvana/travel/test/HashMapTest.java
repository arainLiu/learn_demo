package com.nirvana.travel.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arainliu
 * @date 2021/7/13
 */
public class HashMapTest {

  public static void main(String[] args) {

    Map<Integer, Integer> map = new HashMap<>();

    String untreeifyNodeStr = "[88,216,344,472,600,728,856,89,217,345,473,601,729,857,110,238,366,494,622,750,878,111,239,367,495,623,751,879,112,240,368,496,624,752,880,113,241,369,497,625,753,881,114,242,370,498,626,754,882,115,243,371,499,627,755,883,116,244,372,500,628,756,884]";
    String treeifyNodeStr = "[0,128,256,384,512,640,768,896,1024,1152,1280,1408,1536,1664,1792,1920,2048]";
    List<Integer> unTreeifyList = JSON.parseArray(untreeifyNodeStr, Integer.class);
    List<Integer> treeifyList = JSON.parseArray(treeifyNodeStr, Integer.class);

    //put untreeify node
    for (Integer item : unTreeifyList) {
      map.put(item, item);
    }

    for (Integer elem : treeifyList) {
      map.put(elem, elem);
    }

    System.out.println(111);

    Map<String, List<Integer>> sameMap = Maps.newHashMap();
//    for (Integer it : strings) {
//      int hash = hash(it);
//      int tabslot = 15 & hash;
//      if (sameMap.containsKey(String.valueOf(tabslot))) {
//        List<Integer> list = sameMap.get(String.valueOf(tabslot));
//        list.add(it);
//        continue;
//      }
//
//      sameMap.put(String.valueOf(tabslot), Lists.newArrayList(hash));
//    }
//    System.out.println(JSON.toJSONString(sameMap.get("0")));
//

//    for (int i = 0; i <= 2056; i++) {
//      int hash = hash(i) & 127;
//      if (sameMap.containsKey(String.valueOf(hash))) {
//        List<Integer> list = sameMap.get(String.valueOf(hash));
//        list.add(i);
//        continue;
//      }
//
//      sameMap.put(String.valueOf(hash), Lists.newArrayList(hash));
//    }
//
//    List<Integer> coll = Lists.newArrayList();
//    coll.addAll(sameMap.get("88").subList(0, 7));
//    coll.addAll(sameMap.get("89").subList(0, 7));
//    coll.addAll(sameMap.get("110").subList(0, 7));
//    coll.addAll(sameMap.get("111").subList(0, 7));
//    coll.addAll(sameMap.get("112").subList(0, 7));
//    coll.addAll(sameMap.get("113").subList(0, 7));
//    coll.addAll(sameMap.get("114").subList(0, 7));
//    coll.addAll(sameMap.get("115").subList(0, 7));
//    coll.addAll(sameMap.get("116").subList(0, 7));
//
//    System.out.println("untreeify data: " + JSON.toJSONString(coll));
//    System.out.println("treeify data: " + JSON.toJSONString(sameMap.get("0")));

  }

  private static int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }

}
