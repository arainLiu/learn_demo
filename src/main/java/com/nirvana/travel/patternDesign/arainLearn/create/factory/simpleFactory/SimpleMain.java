package com.nirvana.travel.patternDesign.arainLearn.create.factory.simpleFactory;

/**
 * @author arainliu
 * @date 2023/2/13
 */
public class SimpleMain {

    public static void main(String[] args) {
        Icar icarA = SimpleFactory.buildCar("Acar");
        Icar icarB = SimpleFactory.buildCar("Bcar");
        System.out.println(icarA.build("xiaoming"));
        System.out.println(icarB.build("feiji"));
    }

}
