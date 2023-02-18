package com.nirvana.travel.patternDesign.arainLearn.create.factory.abstractFactory;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class BYDFactory implements BrandFactory{

    @Override
    public ICar createCar() {
        return new BYDCar();
    }

    @Override
    public IBattery createBattery() {
        return new BYDBattery();
    }
}
