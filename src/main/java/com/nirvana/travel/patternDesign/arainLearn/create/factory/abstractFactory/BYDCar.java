package com.nirvana.travel.patternDesign.arainLearn.create.factory.abstractFactory;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class BYDCar implements ICar{

    @Override
    public String buildCar() {
        return "制造一辆比亚迪车";
    }
}
