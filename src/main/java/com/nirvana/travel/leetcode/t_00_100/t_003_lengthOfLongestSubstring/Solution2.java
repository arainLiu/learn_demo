package com.nirvana.travel.leetcode.t_00_100.t_003_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2022/5/20
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        int count = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                //说明当前值已经在map中存在，重置开始位置
                start = Math.max(map.get(arr[i])+1, start);
            }
            count = Math.max(count, end - start + 1);
            map.put(arr[i], i);
            end ++;
        }

        return count;
    }


}
