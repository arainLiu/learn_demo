package com.nirvana.travel.patternDesign.arainLearn.create.factory.factoryMethod;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class BMWCarFactory implements ICarFactory{

    @Override
    public Icar createCar() {
        return new BMWCar();
    }
}
