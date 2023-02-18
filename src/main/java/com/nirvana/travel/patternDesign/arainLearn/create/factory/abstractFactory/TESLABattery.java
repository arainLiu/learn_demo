package com.nirvana.travel.patternDesign.arainLearn.create.factory.abstractFactory;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class TESLABattery implements IBattery{

    @Override
    public String buildBattery() {
        return "特斯拉进口电池";
    }
}
