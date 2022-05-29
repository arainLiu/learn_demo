package com.nirvana.travel.patternDesign.arainLearn.component;

/**
 * @author arainliu
 * @date 2021/4/29
 */
public class HrDepartment extends Company {

  public HrDepartment() {
  }

  public HrDepartment(String name) {
    super(name);
  }

  @Override
  protected void add(Company company) {

  }

  @Override
  protected void remove(Company company) {

  }

  @Override
  public void display(int depth) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < depth; i++) {
      sb.append("-");
    }
    System.out.println(new String(sb) + this.getName() ) ;
  }
}
