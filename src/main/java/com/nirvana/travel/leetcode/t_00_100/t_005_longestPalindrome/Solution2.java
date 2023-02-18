package com.nirvana.travel.leetcode.t_00_100.t_005_longestPalindrome;

/**
 * @author arainliu
 * @date 2022/5/23
 */
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindromeDp("cbacdffdcabd"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        int start = 0;
        int end = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int length1 = longestPalindrome(arr, i, i);
            int length2 = longestPalindrome(arr, i, i+1);
            int largeLength = Math.max(length1, length2);
            if (largeLength > end - start) {
                start = i-(largeLength-1)/2;
                end = i + largeLength/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int longestPalindrome(char[] arr, int i, int j) {

        int ans = 0;
        while (i >= 0 && j < arr.length && arr[i]==arr[j]) {
            ans = j - i + 1;
            i --;
            j ++;
        }

        return ans;
    }

    /**
     * dp[i][j]表示从i到j上是否为回文子串
     *  dp[i][j]分析：
     *    s[i] == s[j], 依赖dp[i+1][j-1]
     *
     * 初始化:dp[i][i] = true;
     * @param s
     * @return
     */
    public String longestPalindromeDp(String s) {

        if (s.length() == 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        char[]  arr = s.toCharArray();
        int start = 0;
        int length = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    int curlen = j - i + 1;
                    if (curlen > length) {
                        length = curlen;
                        start = i;
                    }
                }
            }
        }

        for (boolean[] booleans : dp) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + " ");
            }
            System.out.println();
        }

        return s.substring(start, start+length);
    }
}
