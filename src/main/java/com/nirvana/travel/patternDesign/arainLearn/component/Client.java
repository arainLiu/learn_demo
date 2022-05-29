package com.nirvana.travel.patternDesign.arainLearn.component;

/**
 * @author arainliu
 * @date 2021/4/29
 */
public class Client {

  public static void main(String[] args) {
    Company root = new CompanyComposite();
    root.setName("北京总公司");
    root.add(new HrDepartment("总公司人力资源部"));
    root.add(new FinanceDepartment("总公司财务部"));

    Company shandongCom = new CompanyComposite("山东分公司");
    shandongCom.add(new HrDepartment("山东分公司人力资源部"));
    shandongCom.add(new FinanceDepartment("山东分公司账务部"));

    Company zaozhuangCom = new CompanyComposite("枣庄办事处");
    zaozhuangCom.add(new FinanceDepartment("枣庄办事处财务部"));
    zaozhuangCom.add(new HrDepartment("枣庄办事处人力资源部"));

    Company jinanCom = new CompanyComposite("济南办事处");
    jinanCom.add(new FinanceDepartment("济南办事处财务部"));
    jinanCom.add(new HrDepartment("济南办事处人力资源部"));

    shandongCom.add(jinanCom);
    shandongCom.add(zaozhuangCom);

    Company huadongCom = new CompanyComposite("上海华东分公司");
    huadongCom.add(new HrDepartment("上海华东分公司人力资源部"));
    huadongCom.add(new FinanceDepartment("上海华东分公司账务部"));

    Company hangzhouCom = new CompanyComposite("杭州办事处");
    hangzhouCom.add(new FinanceDepartment("杭州办事处财务部"));
    hangzhouCom.add(new HrDepartment("杭州办事处人力资源部"));

    Company nanjingCom = new CompanyComposite("南京办事处");
    nanjingCom.add(new FinanceDepartment("南京办事处财务部"));
    nanjingCom.add(new HrDepartment("南京办事处人力资源部"));
    huadongCom.add(hangzhouCom);
    huadongCom.add(nanjingCom);

    root.add(shandongCom);
    root.add(huadongCom);
    root.display(0);

  }
}
