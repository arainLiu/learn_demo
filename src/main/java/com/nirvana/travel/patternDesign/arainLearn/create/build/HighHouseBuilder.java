package com.nirvana.travel.patternDesign.arainLearn.create.build;

/**
 * @author arainliu
 * @date 2023/2/21
 */
public class HighHouseBuilder extends AbstractHouseBuilder{

    @Override
    String buildTop() {
        house.setTop("高楼楼顶");
        return "建造高楼楼顶";
    }

    @Override
    String buildBody() {
        house.setBody("高楼墙体");
        return "建造高楼墙体";
    }

    @Override
    String buildFoot() {
        house.setFoot("高楼楼底");
        return "建造高楼楼底";
    }
}
