package com.nirvana.travel.zuoshen.base.class07;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/9
 */
public class reverseTest {

  public static void main(String[] args) {
    String str = "hi,hello world !";
    String[] strArr = str.split("\\s+|[,]");
    StringBuffer sb = new StringBuffer();
    for(int i = strArr.length -1;i > -1; i--){
      sb.append(strArr[i] + " ");
    }
    sb.setCharAt(str.length()-3, ',');
    System.out.println(sb.toString());
  }


}
