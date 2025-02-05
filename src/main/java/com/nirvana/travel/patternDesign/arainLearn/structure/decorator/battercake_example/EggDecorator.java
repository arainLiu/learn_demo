package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.battercake_example;

/**
 * @author arainliu
 * @date 2023/3/23
 */
public class EggDecorator extends BattercakeDecorator{

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "加一个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
