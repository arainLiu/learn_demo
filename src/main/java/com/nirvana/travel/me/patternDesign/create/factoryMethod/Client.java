package com.nirvana.travel.me.patternDesign.create.factoryMethod;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class Client {

  public static void main(String[] args) {

    Factory factory = new SweaterFactory();
    Clothes sweater = factory.createProduct();
    sweater.make();

    Factory factory1 = new TshirtFactory();
    Clothes tshirt = factory1.createProduct();
    tshirt.make();

  }

}
