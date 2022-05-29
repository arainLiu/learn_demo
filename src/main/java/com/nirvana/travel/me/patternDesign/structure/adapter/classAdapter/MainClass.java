package com.nirvana.travel.me.patternDesign.structure.adapter.classAdapter;

/**
 * @author arainliu
 * @date 2021/9/30
 */
public class MainClass {

  public static void main(String[] args) {
    System.out.println("macbook开机");
    Adapter adapter = new Adapter();
    adapter.output20V();
    System.out.println("正常运行");
  }
}
