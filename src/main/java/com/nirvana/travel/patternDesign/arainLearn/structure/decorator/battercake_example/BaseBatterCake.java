package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.battercake_example;

/**
 * @author arainliu
 * @date 2023/3/23
 */
public class BaseBatterCake extends Battercake{

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
