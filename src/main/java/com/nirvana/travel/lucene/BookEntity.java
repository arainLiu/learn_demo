package com.nirvana.travel.lucene;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2020/11/10
 */
public class BookEntity {

  private String id;

  private String name;

  private Integer num;

  private String desc;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
