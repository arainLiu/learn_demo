package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.battercake_example;

/**
 * @author arainliu
 * @date 2023/3/23
 */
public class Test {

    public static void main(String[] args) {
        Battercake battercake = new BaseBatterCake();
        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());
        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());
    }
}
