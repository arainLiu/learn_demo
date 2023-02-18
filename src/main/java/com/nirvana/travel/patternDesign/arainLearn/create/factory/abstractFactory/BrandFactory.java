package com.nirvana.travel.patternDesign.arainLearn.create.factory.abstractFactory;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public interface BrandFactory {

    ICar createCar();

    IBattery createBattery();

}
