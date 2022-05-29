package com.nirvana.travel.me.patternDesign.create.abstractFactory;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class HonorPhoneAndTypeCFactory implements IFactory {

  @Override
  public IPhone createPhone() {
    return new Honor50Phone();
  }

  @Override
  public IEarPhone createEarPhone() {
    return new TypeCEarPhone();
  }
}
