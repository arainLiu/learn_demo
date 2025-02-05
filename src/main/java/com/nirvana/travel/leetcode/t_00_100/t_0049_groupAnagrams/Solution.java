package com.nirvana.travel.leetcode.t_00_100.t_0049_groupAnagrams;

import java.util.*;

/**
 * @author arainliu
 * @date 2024/1/30
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();
        //定义哈希表，key:字母序单词，value：字母序相同的单词
        Map<String, List<String>> wordSortMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] wordChar = strs[i].toCharArray();
            Arrays.sort(wordChar);
            String key = String.valueOf(wordChar);
            if (!wordSortMap.containsKey(key)) {
                wordSortMap.put(key, new ArrayList<>());
            }
            wordSortMap.get(key).add(strs[i]);
        }

        return new ArrayList<>(wordSortMap.values());
    }
}
