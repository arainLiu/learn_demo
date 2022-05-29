package com.nirvana.travel.leetcode.t_00_100.t_020_isValid;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/5/26
 */
public class Solution {

    private Map<Character, Character> matchMap = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public boolean isValid(String s) {

        if ((s.length() & 2) == 1) return false;

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char item = chars[i];
            if (matchMap.containsKey(item)) {
                if (stack.isEmpty() || !stack.peek().equals(matchMap.get(item))) {
                    return false;
                }
            } else {
                stack.push(item);
            }
        }

        return true;
    }


}
