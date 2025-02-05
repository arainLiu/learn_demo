package com.nirvana.travel.patternDesign.arainLearn.create.build;

/**
 * @author arainliu
 * @date 2023/2/21
 */
public class HouseDirector {

    private AbstractHouseBuilder houseBuilder;

    public HouseDirector(AbstractHouseBuilder houseBuilder) {

        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        houseBuilder.buildTop();
        houseBuilder.buildBody();
        houseBuilder.buildFoot();
        return houseBuilder.buildHouse();
    }
}
