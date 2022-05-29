package com.nirvana.travel.me.patternDesign.create.simpleFactory;

/**
 * @author arainliu
 * @date 2021/8/26
 */
public class Client {

  public static void main(String[] args) {
    Car bmwCar = CarFactory.createCar("BMWCar");
    bmwCar.running();

    Car benciCar = CarFactory.createCar("BeachCar");
    benciCar.running();
  }
}
