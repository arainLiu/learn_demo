package com.nirvana.travel.patternDesign.arainLearn.behaviour.stretage;

/**
 * @author arainliu
 * @date 2023/3/13
 */
public class MainTest {

    public static void main(String[] args) {
        double price = 100;
        int num = 1;
        MemberStrategy primaryStrategy = new PrimaryMemberStrategy();
        StrategyContext context = new StrategyContext(primaryStrategy);
        context.calPrice(price, num);
    }
}
