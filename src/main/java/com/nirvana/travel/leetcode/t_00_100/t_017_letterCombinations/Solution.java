package com.nirvana.travel.leetcode.t_00_100.t_017_letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arainliu
 * @date 2022/5/25
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        combinationLetter(digits, ans, 0, new StringBuffer());
        return ans;
    }

    private void combinationLetter(String digits, List<String> ans, int index, StringBuffer sb) {
        //回溯结束条件
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String indexNumStr = phoneMap.get(digits.charAt(index));
        char[] arr = indexNumStr.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            combinationLetter(digits, ans, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }

    private static Map<Character, String> phoneMap = new HashMap<Character, String>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
}
