package com.nirvana.travel.patternDesign.arainLearn.strategy;

import java.math.BigDecimal;

/**
 * @author arainliu
 * @date 2021/5/3
 */
public class OfflinePriceStrategy implements PayScenePriceStrategy {

  private OrderEntity orderEntity;

  public OfflinePriceStrategy(
    OrderEntity orderEntity) {
    this.orderEntity = orderEntity;
  }

  @Override
  public BigDecimal calculatePayPrice() {
    orderEntity.setPrice(new BigDecimal(0));
    System.out.println("线下支付算价");
    return orderEntity.getPrice();
  }

  @Override
  public boolean paySuccess() {
    System.out.println("线下支付是否支付成功");
    orderEntity.setPaySuccess(true);
    return orderEntity.getPaySuccess();
  }
}
