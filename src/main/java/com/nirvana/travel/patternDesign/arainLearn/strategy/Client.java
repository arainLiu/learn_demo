package com.nirvana.travel.patternDesign.arainLearn.strategy;

/**
 * @author arainliu
 * @date 2021/5/3
 */
public class Client {

  public static void main(String[] args) {
    PayScenePriceStrategy strategy = new OfflinePriceStrategy(new OrderEntity());
    PriceContext context = new PriceContext(strategy);
    System.out.println(context.getprice());
    System.out.println(context.paySuccess());
  }
}
