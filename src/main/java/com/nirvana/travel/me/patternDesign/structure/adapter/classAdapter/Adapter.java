package com.nirvana.travel.me.patternDesign.structure.adapter.classAdapter;

/**
 * @author arainliu
 * @date 2021/9/30
 */
public class Adapter extends Adaptee implements Target {

  @Override
  public int output20V() {
    int output220V = this.output220V();
    System.out.println("处理电压：" + output220V + ",转换为：20V");

    return 20;
  }
}
