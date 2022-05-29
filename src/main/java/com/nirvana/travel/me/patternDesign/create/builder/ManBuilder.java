package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public class ManBuilder implements Builder {

  private Human human;

  public ManBuilder() {
    this.human = new Man();
  }

  @Override
  public void buildHead() {
    System.out.println("女娲造人-男人头部");
    human.setHead("男人头部");
  }

  @Override
  public void buildBody() {
    System.out.println("女娲造人-男人身体");
    human.setBody("男人身体");
  }

  @Override
  public void buildFoot() {
    System.out.println("女娲造人-男人脚部");
    human.setFoot("男人脚部");
  }

  @Override
  public Human buildHuman() {
    return human;
  }
}
