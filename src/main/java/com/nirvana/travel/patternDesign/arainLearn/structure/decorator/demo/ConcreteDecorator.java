package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.demo;

/**
 * @author arainliu
 * @date 2023/3/15
 */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public String operate() {
        beforeOperate();
        final String operate = super.operate();
        afterOperate();
        return operate;
    }

    private String beforeOperate() {
        System.out.println("前置处理");
        return "前置处理";
    }

    private String afterOperate() {
        System.out.println("后置操作");
        return "后置操作";
    }
}
