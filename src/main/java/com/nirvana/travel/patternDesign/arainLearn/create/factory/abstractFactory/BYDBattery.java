package com.nirvana.travel.patternDesign.arainLearn.create.factory.abstractFactory;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class BYDBattery implements IBattery{

    @Override
    public String buildBattery() {
        return "制造比亚迪电池";
    }
}
