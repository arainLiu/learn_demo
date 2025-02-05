package com.nirvana.travel.patternDesign.arainLearn.create.build;

/**
 * @author arainliu
 * @date 2023/2/21
 */
public class CommonHouseBuilder extends AbstractHouseBuilder{

    @Override
    public String buildTop() {
        house.setTop("普通房屋顶部");
        return "建造普通房屋顶部";
    }

    @Override
    public String buildBody() {
        house.setBody("普通房屋墙体");
        return "建造普通房屋墙体";
    }

    @Override
    public String buildFoot() {
        house.setFoot("普通房屋屋底");
        return "建造普通房屋屋底";
    }
}
