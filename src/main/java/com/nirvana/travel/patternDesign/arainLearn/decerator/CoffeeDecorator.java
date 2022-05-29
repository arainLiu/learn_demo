package com.nirvana.travel.patternDesign.arainLearn.decerator;

/**
 * @author arainliu
 * @date 2021/5/1
 */
public abstract class CoffeeDecorator implements Coffee {

  private final Coffee coffee;

  public CoffeeDecorator(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public double getCost() {
    return coffee.getCost();
  }

  @Override
  public String getIngredients() {
    return coffee.getIngredients();
  }
}
