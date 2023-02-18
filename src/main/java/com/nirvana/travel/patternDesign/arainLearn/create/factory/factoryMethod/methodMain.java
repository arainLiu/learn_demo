package com.nirvana.travel.patternDesign.arainLearn.create.factory.factoryMethod;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class methodMain {

    public static void main(String[] args) {
        ICarFactory carFactory1 = new BMWCarFactory();
        Icar car = carFactory1.createCar();
        System.out.println(car.buildCar());
    }
}
