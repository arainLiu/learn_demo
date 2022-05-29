package com.nirvana.travel.patternDesign.arainLearn.strategy;

import java.math.BigDecimal;

/**
 * @author arainliu
 * @date 2021/5/3
 */
public class PriceContext {

  private PayScenePriceStrategy strategy;

  public PriceContext(
    PayScenePriceStrategy strategy) {
    this.strategy = strategy;
  }

  public BigDecimal getprice() {
    return strategy.calculatePayPrice();
  }

  public Boolean paySuccess() {
    return strategy.paySuccess();
  }
}
