package com.nirvana.travel.patternDesign.arainLearn.strategy;

import java.math.BigDecimal;

/**
 * @author arainliu
 * @date 2021/5/3
 */
public interface PayScenePriceStrategy {

  /**
   * 价格计算
   *
   * @return
   */
  BigDecimal calculatePayPrice();

  /**
   * 支付成功处理
   *
   */
  boolean paySuccess();

}
