package com.nirvana.travel.leetcode.t_0301_0400.t_392_isSubsequence;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * @date 2022/5/10
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Solution().isSubsequenceDp(s, t));
    }

    /**
     *  首先是贪心实现方式
     *    判断s是否为t的子串
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sp = 0, tp = 0;
        while (sp < sArr.length && tp < tArr.length) {
            if (sArr[sp] == tArr[tp]) {
                sp++;
            }
            tp ++;
        }

        return sArr.length == sp;

    }

    /**
     * 根据题意，有些类似于求两个字符串的最大公共子排列
     *
     * dp[i][j] 表示s从0到i-1, t从0到j-1上的最大子序列数量
     * dp[i][j]推导：
     *   s[i-1] == t[j-1], 此时为 dp[i-1][j-1]+1；
     *   s[i-1] != t[j-1],此时t需要删除j-1,相当于需要去s[i-1]和t[j-2]的结果，此时 dp[i][j]= dp[i][j-1]
     *
     * 初始化：根据动态转移方式，需要关系dp[0][0]和dp[i][0],将数组从1开始，0位置无实质意义，全部取0
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequenceDp(String s, String t) {

        if (s.length() == 0) return true;
        if (t.length()==0 || s.length() > t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 1; i <= sArr.length; i++) {
            for (int j = 1; j <= tArr.length; j++) {
                if (sArr[i-1] == tArr[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[sArr.length][tArr.length] == sArr.length;

    }
}
