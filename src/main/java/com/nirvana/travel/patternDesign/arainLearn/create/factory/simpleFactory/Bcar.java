package com.nirvana.travel.patternDesign.arainLearn.create.factory.simpleFactory;

/**
 * @author arainliu
 * @date 2023/2/13
 */
public class Bcar implements Icar {

    @Override
    public String build(String carName) {
        return "制造一辆B车：" + carName;
    }
}
