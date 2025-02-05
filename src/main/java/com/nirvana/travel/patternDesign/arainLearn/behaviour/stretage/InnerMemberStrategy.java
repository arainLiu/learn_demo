package com.nirvana.travel.patternDesign.arainLearn.behaviour.stretage;

/**
 * @author arainliu
 * @date 2023/3/13
 */
public class InnerMemberStrategy extends MemberStrategy{

    @Override
    double calculate(double price, int num) {
        System.out.println("内部员工打八折");
        return price * num * 0.8;
    }
}
