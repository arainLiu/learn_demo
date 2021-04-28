package com.nirvana.travel.javabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author arainliu
 * @date 2021/4/14
 */
public class SynchronizedTest {

  public static void main(String[] args) {

    Set<List<Integer>> set = new HashSet<>();
    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    l1.add(2);
    l1.add(3);

    List<Integer> l2 = new ArrayList<>();
    l2.add(1);
    l2.add(2);
    l2.add(3);
    set.add(l1);
    set.add(l2);

    System.out.println(set);

//    test3();
  }
  public synchronized void test1() {
  }

  public void test2() {
    synchronized (this) {

    }
  }

  public static synchronized void test3() {
  }

}
