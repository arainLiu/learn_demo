package com.nirvana.travel.leetcode.t_0601_0700.t_0647_countSubstrings;

/**
 * @author arainliu
 * @date 2022/5/11
 */
public class Solution {

    /**
     * 判断回文子串：
     * 回文子串特点是从i...j上对称
     * 定义dp[i][j]表示字符串从[i...j]是否为回文字符串，true表示是，false表示否
     *
     * dp[i][j]推导：
     *   1. s[i]!=s[j],此时为false
     *   2. s[i] == s[j],
     *      如果i==j,此时是同一个字符，也是true
     *      如果i和j相差1，则此时=true
     *      如果i和j相差大于1，则依赖s[i+1]和s[j-1]，即dp[i+1][j-1]
     *
     *  初始化：
     *   根据状态转移方程，需要依赖左下角元素
     *   初始值为false，默认都不是回文
     *
     * @param s
     * @return
     */
    public int countSubstringsDp(String s) {

        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[arr.length][arr.length];

        int ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (j-i <= 1) {
                        dp[i][j] = true;
                        ans++;
                    } else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 中心扩散法
     *   选择一个中心点，向两边扩散.分两种情况
     *     1. i作为中心点
     *     2.i,i+1作为中心点
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        if (s.length() == 0) return 0;
        if (s.length() ==1) return 1;

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += countSub(s, i, i, 0, s.length());
            ans += countSub(s, i, i+1, 0, s.length());
        }

        return ans;
    }

    private int countSub(String s, int c1, int c2, int start, int end) {
        int res = 0;
        char[] arr = s.toCharArray();
        while (c1 >= start && c2 < end && arr[c2]== arr[c1]) {
            c1--;
            c2++;
            res++;
        }
        return res;
    }
}
