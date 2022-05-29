package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public class MainTest {

  public static void main(String[] args) {
    Director director = new Director();
    Human woman = director.createHuman(new WomanBuilder());
    System.out.println(woman);

    Human man = director.createHuman(new ManBuilder());
    System.out.println(man);
  }

}
