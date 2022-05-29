package com.nirvana.travel.patternDesign.arainLearn.component;

/**
 * @author arainliu
 * @date 2021/4/29
 */
public abstract class Company {

  private String name;

  public Company() {
  }

  public Company(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  protected abstract void add(Company company);

  protected abstract void remove(Company company);

  public abstract void display(int depth);
}
