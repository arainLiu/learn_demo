package com.nirvana.travel.me.patternDesign.create.prototype.copy.simple;

/**
 * @author arainliu
 * @date 2021/9/27
 */
public class UserPrototype implements Cloneable {

  private String name;

  private String age;

  @Override
  protected UserPrototype clone() throws CloneNotSupportedException {
    return ((UserPrototype) super.clone());
  }

  public UserPrototype(String name, String age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return this.hashCode() + " : UserPrototype{" +
      "name='" + name + '\'' +
      ", age='" + age + '\'' +
      '}';
  }
}
