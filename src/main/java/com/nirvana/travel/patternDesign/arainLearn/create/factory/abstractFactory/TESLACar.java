package com.nirvana.travel.patternDesign.arainLearn.create.factory.abstractFactory;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class TESLACar implements ICar{

    @Override
    public String buildCar() {
        return "制造特斯拉汽车";
    }
}
