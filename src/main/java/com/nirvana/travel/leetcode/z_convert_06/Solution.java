package com.nirvana.travel.leetcode.z_convert_06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arainliu
 * @date 2021/2/19
 */
public class Solution {

  public static void main(String[] args) {
    String s = "1234567890abcdefghijklmn";
    System.out.println(convert(s,3));
  }

  public static String convert(String s, int numRows) {
    if (numRows == 1) return s;

    List<StringBuffer> rowElems = new ArrayList<>();
    for (int i = 0; i< Math.min(s.length(), numRows); i ++) {
      rowElems.add(new StringBuffer());
    }

    int curRow = 0;
    boolean goDown = false;

    char[] charArr = s.toCharArray();
    for (char c : charArr) {
      rowElems.get(curRow).append(c);
      if (curRow == 0 || curRow == numRows - 1) goDown = !goDown;

      curRow += goDown ? 1 : -1;
    }

    StringBuffer retBf = new StringBuffer();
    for (StringBuffer bf : rowElems)
      retBf.append(bf);

    return retBf.toString();
  }

}
