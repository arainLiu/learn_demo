package com.nirvana.travel.me.patternDesign.create.abstractFactory;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class VivoPhoneAndAndroidFactory implements IFactory {

  @Override
  public IPhone createPhone() {
    return new VivoX20Phone();
  }

  @Override
  public IEarPhone createEarPhone() {
    return new AndroidEarPhone();
  }
}
