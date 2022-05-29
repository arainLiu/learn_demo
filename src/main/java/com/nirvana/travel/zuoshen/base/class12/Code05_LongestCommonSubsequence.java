package com.nirvana.travel.zuoshen.base.class12;

public class Code05_LongestCommonSubsequence {

	public static int lcse(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];

		//填第0行0列的所有值
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		//填充第0行所有值
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		//填充第0列所有值
		for (int j = 1; j < str2.length; j++) {
			//当str1[0] == str2[j]时，表示str2上某个字符==str1[0]，剩下的字符全部置为1
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}

		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				// 列举可能性：
				// 1.最长公共子序列 既不包含str1[i]，也不包含str2[j], 最大子序列为dp[i-1][j-1]
				// 2.最长公共子序列 包含str1[i]，不包含str2[j], 最大子序列为dp[i][j-1]
				// 3.最长公共子序列 不包含str1[i]，包含str2[j], 最大子序列为dp[i-1][j]
				// 4.最长公共子序列 既包含str1[i]，也包含str2[j], 最大子序列为dp[i-1][j-1]+1
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		return dp[str1.length - 1][str2.length - 1];
	}

	public static void main(String[] args) {

	}

}
