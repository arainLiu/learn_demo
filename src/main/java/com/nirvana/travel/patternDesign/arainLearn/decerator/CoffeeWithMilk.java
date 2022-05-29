package com.nirvana.travel.patternDesign.arainLearn.decerator;

/**
 * @author arainliu
 * @date 2021/5/1
 */
public class CoffeeWithMilk extends CoffeeDecorator{

  public CoffeeWithMilk(Coffee coffee) {
    super(coffee);
  }

  @Override
  public double getCost() {
    return super.getCost() + 1.5;
  }

  @Override
  public String getIngredients() {
    return super.getIngredients() + ", Milk";
  }

}
