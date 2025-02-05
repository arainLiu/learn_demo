package com.nirvana.travel.patternDesign.arainLearn.structure.decorator.demo;/**
 * @author arainliu
 * @date  2023/3/15
 */
public class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public String operate() {
        return component.operate();
    }
}
