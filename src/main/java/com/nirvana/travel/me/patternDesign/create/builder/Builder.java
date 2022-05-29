package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public interface Builder {

  void buildHead();

  void buildBody();

  void buildFoot();

  Human buildHuman();

}
