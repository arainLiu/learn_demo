package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.battercake_example;

/**
 * @author arainliu
 * @date 2023/3/23
 */
public abstract class BattercakeDecorator extends Battercake{

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return battercake.getPrice();
    }
}
