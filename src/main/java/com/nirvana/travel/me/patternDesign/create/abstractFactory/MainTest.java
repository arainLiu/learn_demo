package com.nirvana.travel.me.patternDesign.create.abstractFactory;

/**
 * @author arainliu
 * @date 2021/8/30
 */
public class MainTest {

  public static void main(String[] args) {
    IFactory factory1 = new HonorPhoneAndTypeCFactory();
    IPhone phone1 = factory1.createPhone();
    IEarPhone earPhone1 = factory1.createEarPhone();
    phone1.makePhone();
    earPhone1.makeEarPhone();

    IFactory factory2 = new VivoPhoneAndAndroidFactory();
    IPhone phone2 = factory2.createPhone();
    IEarPhone earPhone2 = factory2.createEarPhone();
    phone2.makePhone();
    earPhone2.makeEarPhone();
  }

}
