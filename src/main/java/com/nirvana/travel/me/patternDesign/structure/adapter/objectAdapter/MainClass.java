package com.nirvana.travel.me.patternDesign.structure.adapter.objectAdapter;

/**
 * @author arainliu
 * @date 2021/9/30
 */
public class MainClass {

  public static void main(String[] args) {
    System.out.println("macbook开机");
    ObjectAdapter adapter = new ObjectAdapter(new ObjectAdaptee());
    adapter.requst20V();
    System.out.println("正常运行");
  }
}
