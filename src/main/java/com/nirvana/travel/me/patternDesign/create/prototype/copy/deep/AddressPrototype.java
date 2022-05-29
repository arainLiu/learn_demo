package com.nirvana.travel.me.patternDesign.create.prototype.copy.deep;

/**
 * @author arainliu
 * @date 2021/9/27
 */
public class AddressPrototype implements Cloneable {

  private String address;

  public AddressPrototype(String address) {
    this.address = address;
  }


  @Override
  protected AddressPrototype clone() throws CloneNotSupportedException {
    return ((AddressPrototype) super.clone());
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return this.hashCode() + " : AddressPrototype{" +
      "address='" + address + '\'' +
      '}';
  }
}
