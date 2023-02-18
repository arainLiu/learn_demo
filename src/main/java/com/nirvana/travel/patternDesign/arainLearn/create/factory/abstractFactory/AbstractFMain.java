package com.nirvana.travel.patternDesign.arainLearn.create.factory.abstractFactory;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class AbstractFMain {

    public static void main(String[] args) {
        ICar car = new BYDFactory().createCar();
        System.out.println(car.buildCar());
        IBattery battery = new BYDFactory().createBattery();
        System.out.println(battery.buildBattery());

        System.out.println("=======================");

        ICar carB = new TESLAFactory().createCar();
        System.out.println(carB.buildCar());
        IBattery batteryB = new TESLAFactory().createBattery();
        System.out.println(batteryB.buildBattery());
    }
}
