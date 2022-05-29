package com.nirvana.travel.me.base.compare;

import com.alibaba.fastjson.JSON;
import java.util.TreeSet;

/**
 * @author arainliu
 * @date 2021/9/6
 */
public class MainTest {

  public static void main(String[] args) {

    TreeSet<User> treeSet = new TreeSet<User>();
    User user1 = new User("name1", 13);
    treeSet.add(user1);
    treeSet.add(new User("name2", 14));
    treeSet.add(new User("name3", 9));

    for (User user : treeSet) {
      System.out.println(JSON.toJSONString(user
      ));
    }
  }

}
