package com.nirvana.travel.patternDesign.arainLearn.decerator;

/**
 * @author arainliu
 * @date 2021/5/1
 */
public class Demo {

  static void print(Coffee c) {
    System.out.println("花费了: " + c.getCost());
    System.out.println("配料: " + c.getIngredients());
    System.out.println("============");
  }

  public static void main(String[] args) {
    //原味咖啡
    Coffee c = new SimpleCoffee(); print(c);
    //增加牛奶的咖啡
    c = new CoffeeWithMilk(c);
    print(c);
    //再加一点糖
    c = new CoffeeWithSugar(c);
    print(c);
  }

  }
