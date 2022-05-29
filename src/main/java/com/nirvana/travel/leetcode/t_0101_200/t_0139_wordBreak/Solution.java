package com.nirvana.travel.leetcode.t_0101_200.t_0139_wordBreak;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * @date 2022/4/29
 */
public class Solution {

    /**
     * 从题意上来说，是使用有限个单词填满字符串s，
     * 类似于n个物品装满容量w的背包，可以按完全背包的思路来实现
     * dp[i] 表示字符串长度i的时候是否能够由单词填满
     *   假定存在j < i, dp[j] = true, 字符串子串（j,i）可以由单词填充，那么dp[i] = true
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String splitStr = s.substring(j, i);
                if (wordSet.contains(splitStr) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("123".substring(1,1));
    }
}
