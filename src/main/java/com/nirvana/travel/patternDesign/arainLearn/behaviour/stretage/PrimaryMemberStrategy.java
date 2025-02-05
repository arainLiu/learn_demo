package com.nirvana.travel.patternDesign.arainLearn.behaviour.stretage;

/**
 * @author arainliu
 * @date 2023/3/13
 */
public class PrimaryMemberStrategy extends MemberStrategy{

    @Override
    double calculate(double price, int num) {
        System.out.println("普通会员会员不打折");
        return price * num;
    }
}
