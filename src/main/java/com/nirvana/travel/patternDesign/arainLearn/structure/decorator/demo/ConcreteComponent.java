package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.demo;/**
 * @author arainliu
 * @date  2023/3/15
 */

public class ConcreteComponent extends Component {

    @Override
    public String operate() {
        System.out.println("处理业务逻辑");
        return "处理业务逻辑";
    }
}
