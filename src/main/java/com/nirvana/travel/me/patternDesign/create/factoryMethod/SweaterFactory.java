package com.nirvana.travel.me.patternDesign.create.factoryMethod;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class SweaterFactory implements Factory {

  @Override
  public Clothes createProduct() {
    return new Sweater();
  }
}
