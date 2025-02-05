package com.nirvana.travel.patternDesign.arainLearn.create.build;

/**
 * @author arainliu
 * @date 2023/2/21
 */
public abstract class AbstractHouseBuilder {

    House house = new House();
    abstract String buildTop();
    abstract String buildBody();
    abstract String buildFoot();

    House buildHouse() {
        return house;
    }
}
