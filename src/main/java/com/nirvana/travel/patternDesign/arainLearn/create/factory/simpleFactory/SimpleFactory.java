package com.nirvana.travel.patternDesign.arainLearn.create.factory.simpleFactory;

/**
 * @author arainliu
 * @date 2023/2/13
 */
public class SimpleFactory {

    public static Icar buildCar(String carType) {

        Icar icar = null;
        if (carType == "Acar") {
            icar = new Acar();
        } else if (carType == "Bcar") {
            icar = new Bcar();
        }

        return icar;
    }
}
