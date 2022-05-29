package com.nirvana.travel.patternDesign.arainLearn.component;

import com.nirvana.travel.patternDesign.arainLearn.component.Company;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 容器组件
 *
 * @author arainliu
 * @date 2021/4/29
 */
public class CompanyComposite extends Company {

  /**
   * 管理组件间与子组件有关的关系
   */
  List<Company> companyList;

  public CompanyComposite(String name) {
    super(name);
    this.companyList = new ArrayList<>();
  }

  public CompanyComposite() {
    this.companyList = new ArrayList<>();
  }

  @Override
  protected void add(Company company) {
    companyList.add(company);
  }

  @Override
  protected void remove(Company company) {
    companyList.add(company);
  }

  @Override
  public void display(int depth) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < depth; i++) {
      sb.append("-");
    }
    System.out.println(new String(sb) + this.getName());
    for (Company c : companyList) {
      c.display(depth + 2);
    }
  }
}
