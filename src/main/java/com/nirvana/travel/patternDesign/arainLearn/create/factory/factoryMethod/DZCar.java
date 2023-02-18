package com.nirvana.travel.patternDesign.arainLearn.create.factory.factoryMethod;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class DZCar implements Icar{

    @Override
    public String buildCar() {
        return "制造大众车";
    }
}
