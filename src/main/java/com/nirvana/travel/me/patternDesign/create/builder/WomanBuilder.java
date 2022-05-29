package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public class WomanBuilder implements Builder {

  private Human human;

  public WomanBuilder() {
    this.human = new Woman();
  }

  @Override
  public void buildHead() {
    System.out.println("女娲造人-女人头部");
    human.setHead("女人头部");
  }

  @Override
  public void buildBody() {
    System.out.println("女娲造人-女人身体");
    human.setBody("女人身体");
  }

  @Override
  public void buildFoot() {
    System.out.println("女娲造人-女人脚部");
    human.setFoot("女人脚部");
  }

  @Override
  public Human buildHuman() {
    return human;
  }
}
