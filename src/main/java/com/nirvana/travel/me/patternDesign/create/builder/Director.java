package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public class Director {

  Human createHuman(Builder builder) {
    builder.buildHead();
    builder.buildBody();
    builder.buildFoot();

    return builder.buildHuman();
  }
}
