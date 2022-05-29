package com.nirvana.travel.me.patternDesign.structure.adapter.objectAdapter;

/**
 * @author arainliu
 * @date 2021/9/30
 */
public class ObjectAdapter implements ObjectTarget {

  private ObjectAdaptee objectAdaptee;

  public ObjectAdapter(ObjectAdaptee objectAdaptee) {
    this.objectAdaptee = objectAdaptee;
  }

  @Override
  public String requst20V() {
    String output220V = objectAdaptee.output220V();
    System.out.println("源输出电压："+ output220V + "转换为 20V.");
    return "20v";
  }
}
