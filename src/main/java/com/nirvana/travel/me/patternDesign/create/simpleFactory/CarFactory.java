package com.nirvana.travel.me.patternDesign.create.simpleFactory;

/**
 * @author arainliu
 * @date 2021/8/26
 */
public class CarFactory {

  public static Car createCar(String carName) {

    switch (carName) {
      case "BMWCar":
        return new BMWCar();

      case "BeachCar":
        return new BeachCar();

      default:
        throw new RuntimeException();
    }
  }

}
