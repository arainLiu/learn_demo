package com.nirvana.travel.me.patternDesign.create.prototype.copy.deep;

/**
 * @author arainliu
 * @date 2021/9/27
 */
public class MainTest2 {

  public static void main(String[] args) throws CloneNotSupportedException {
    UserPrototype2 userPrototype = new UserPrototype2("xiaoli", "12", new AddressPrototype("dizhi1"));


    UserPrototype2 prototype1 = userPrototype.clone();
    UserPrototype2 prototype2 = userPrototype.clone();

    userPrototype.getAddress().setAddress("111111");
    System.out.println(userPrototype);
    System.out.println(prototype1);
    System.out.println(prototype2);

  }

}
