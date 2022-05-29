package com.nirvana.travel.me.patternDesign.create.prototype.copy.simple;

/**
 * @author arainliu
 * @date 2021/9/27
 */
public class MainTest1 {

  public static void main(String[] args) throws CloneNotSupportedException {
    UserPrototype userPrototype = new UserPrototype("xiaoli", "12");

    System.out.println(userPrototype);

    UserPrototype prototype1 = userPrototype.clone();
    UserPrototype prototype2 = userPrototype.clone();

    System.out.println(prototype1);
    System.out.println(prototype2);

  }

}
