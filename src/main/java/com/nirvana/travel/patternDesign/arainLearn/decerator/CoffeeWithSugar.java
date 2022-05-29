package com.nirvana.travel.patternDesign.arainLearn.decerator;

/**
 * @author arainliu
 * @date 2021/5/1
 */
public class CoffeeWithSugar extends CoffeeDecorator {

  public CoffeeWithSugar(Coffee coffee) {
    super(coffee);
  }

  @Override
  public double getCost() {
    return super.getCost() + 2;
  }

  @Override
  public String getIngredients() {
    return super.getIngredients() + ",Sugar";
  }
}
