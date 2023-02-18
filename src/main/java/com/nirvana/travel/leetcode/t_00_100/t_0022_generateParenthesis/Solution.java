package com.nirvana.travel.leetcode.t_00_100.t_0022_generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arainliu
 * @date 2021/12/28
 */
public class Solution {

  public List<String> generateParenthesis(int n) {

    List<String> ans = new ArrayList<>();
    backTrace(ans, 0, 0, n, new StringBuffer());
    return ans;
  }

  private void backTrace(List<String> ans, int left, int right, int num, StringBuffer cur) {
    if (cur.length() == 2*num) {
      ans.add(cur.toString());
      return;
    }

    if (left < num) {
      cur.append("(");
      backTrace(ans, left+1, right, num, cur);
      cur.deleteCharAt(cur.length() - 1);
    }

    if (right < left) {
      cur.append(")");
      backTrace(ans, left, right+1, num, cur);
      cur.deleteCharAt(cur.length() - 1);
    }
  }

}
