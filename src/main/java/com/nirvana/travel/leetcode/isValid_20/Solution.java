package com.nirvana.travel.leetcode.isValid_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2021/4/19
 */
public class Solution {

  public static void main(String[] args) {

  }

  public boolean isValid(String s) {
    if(s == null || (s.length()&1) != 0) {
      return false;
    }

    Map<Character, Character> compMap = new HashMap();
    compMap.put(')', '(');
    compMap.put(']', '[');
    compMap.put('}', '{');

    Stack<Character> stack = new Stack();
    char[] array = s.toCharArray();
    for (char x : array) {
      if(compMap.containsKey(x)) {
        if(compMap.get(x) == stack.peek()) {
          stack.pop();
        }
      } else {
        stack.push(x);
      }
    }

    return stack.isEmpty();
  }

}
