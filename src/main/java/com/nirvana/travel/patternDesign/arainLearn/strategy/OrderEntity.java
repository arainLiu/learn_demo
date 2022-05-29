package com.nirvana.travel.patternDesign.arainLearn.strategy;

import java.math.BigDecimal;

/**
 * @author arainliu
 * @date 2021/5/3
 */
public class OrderEntity {

  private BigDecimal price;

  private Boolean paySuccess;

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Boolean getPaySuccess() {
    return paySuccess;
  }

  public void setPaySuccess(Boolean paySuccess) {
    this.paySuccess = paySuccess;
  }
}
