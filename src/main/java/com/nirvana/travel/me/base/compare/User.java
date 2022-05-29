package com.nirvana.travel.me.base.compare;

/**
 * @author arainliu
 * @date 2021/9/6
 */
public class User implements Comparable<User> {

  private String name;

  private Integer age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public User() {
  }

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(User o) {
    return this.age - o.age;
  }
}
