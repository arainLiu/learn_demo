package com.nirvana.travel.patternDesign.arainLearn.behaviour.stretage;

/**
 * @author arainliu
 * @date 2023/3/13
 */
public class HighLevelMemberStrategy extends MemberStrategy{

    @Override
    double calculate(double price, int num) {
        System.out.println("高级会员打八五折");
        return price * num * 0.85;
    }
}
