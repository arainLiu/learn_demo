package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.demo;

/**
 * @author arainliu
 * @date 2023/3/15
 */
public class client {

    public static void main(String[] args) {

        System.out.println(1200002718 % 16);
        System.out.println(1200002718 % 2048);

        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operate();
    }
}
