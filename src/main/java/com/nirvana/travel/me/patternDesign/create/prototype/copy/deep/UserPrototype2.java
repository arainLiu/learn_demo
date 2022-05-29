package com.nirvana.travel.me.patternDesign.create.prototype.copy.deep;

/**
 * @author arainliu
 * @date 2021/9/27
 */
public class UserPrototype2 implements Cloneable {

  private String name;

  private String age;

  private AddressPrototype address;

//
//  @Override
//  protected UserPrototype2 clone() throws CloneNotSupportedException {
//    return ((UserPrototype2) super.clone());
//  }


  @Override
  protected UserPrototype2 clone() throws CloneNotSupportedException {

    //impl1
    UserPrototype2 prototype = (UserPrototype2) super.clone();
    prototype.setAddress(this.address.clone());

    return prototype;
  }


  public UserPrototype2(String name, String age,
    AddressPrototype address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public AddressPrototype getAddress() {
    return address;
  }

  public void setAddress(
    AddressPrototype address) {
    this.address = address;
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
    return "UserPrototype2{" +
      "name='" + name + '\'' +
      ", age='" + age + '\'' +
      ", address=" + address +
      '}';
  }
}
