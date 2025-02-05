package com.nirvana.travel.patternDesign.arainLearn.behaviour.stretage;

/**
 * @author arainliu
 * @date 2023/3/13
 */
public class StrategyContext {

    private MemberStrategy memberStrategy;

    public StrategyContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public double calPrice(double price, int num) {
        return memberStrategy.calculate(price, num);
    }
}
