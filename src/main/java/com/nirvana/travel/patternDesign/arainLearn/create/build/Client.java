package com.nirvana.travel.patternDesign.arainLearn.create.build;

import com.alibaba.fastjson.JSON;

/**
 * @author arainliu
 * @date 2023/2/21
 */
public class Client {

    public static void main(String[] args) {

        HouseDirector houseDirector = new HouseDirector(new CommonHouseBuilder());
        House commonHouse = houseDirector.constructHouse();
        System.out.println(JSON.toJSONString(commonHouse));

        System.out.println("++++++++++++++++++++++++++++++");

        HouseDirector highDirect = new HouseDirector(new HighHouseBuilder());
        House highHouse = highDirect.constructHouse();
        System.out.println(JSON.toJSONString(highHouse));

    }
}
