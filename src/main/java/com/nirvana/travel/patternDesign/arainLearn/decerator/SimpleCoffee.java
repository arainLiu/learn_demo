package com.nirvana.travel.patternDesign.arainLearn.decerator;

/**
 * 咖啡的核心功能
 * @author arainliu
 * @date 2021/5/1
 */
public class SimpleCoffee implements Coffee {

  public SimpleCoffee() {
  }

  @Override
  public double getCost() {
    return 1;
  }

  @Override
  public String getIngredients() {
    return "Coffee";
  }
}
