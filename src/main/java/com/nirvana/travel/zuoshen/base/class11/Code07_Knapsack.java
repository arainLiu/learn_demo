package com.nirvana.travel.zuoshen.base.class11;

/**
 * 从左往右模型，背包问题暴力递归
 */
public class Code07_Knapsack {

	public static int getMaxValue(int[] w, int[] v, int bag) {
		return process(w, v, 0, 0, bag);
	}

	// 不变，w,v, bag,递归表示的是从index和往后的货物自由选择
	// index... 最大价值
	//0...index-1上做了货物的选择，使得你已经达到的重量是多少alreadyW
	// 如果返回-1，表示没有这种方案
	//如果不返回-1，则认为返回的东西是真实价值
	public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
		if (alreadyW > bag) {
			return -1;
		}
		// 重量没超
		if (index == w.length) {
			return 0;
		}
		// 可能性1：不包含当前货物，后面的货物产生的最大价值是多少
		int p1 = process(w, v, index + 1, alreadyW, bag);
		// 可能性2：包含当前货物，后面的货物产生的最大价值是多少
		int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
		int p2 = -1;
		if (p2next != -1) {
			p2 = v[index] + p2next;//可能性2的最大价值
		}
		return Math.max(p1, p2);//方案1和方案2的最大价值

	}

	//第二种思路实现，思维换成还剩下多少空间来求最大重量
	//背包问题最经典的写法
	public static int maxValue(int[] w, int[] v, int bag) {
		return process(w, v, 0, bag);
	}

	// 只剩下rest的空间了，
	// index...货物自由选择，但是不要超过rest的空间，剩余空间不要小于0
	// 返回index... 能够获得的最大价值
	public static int process(int[] w, int[] v, int index, int rest) {
		if (rest < 0) { // base case 1
			return -1;//表示无效方案
		}
		// rest >=0
		if (index == w.length) { // base case 2
			return 0;//当index来到终止位置，没有价值
		}
		// 有货也有空间

		//可能性1：不包含当前货，剩下货物所产生的价值
		int p1 = process(w, v, index + 1, rest);

		//可能性2：包含当前货，剩下货物所产生的价值
		int p2 = -1;
		int p2Next = process(w, v, index + 1, rest - w[index]);
		if (p2Next != -1) {
			p2 = v[index] + p2Next;
		}

		return Math.max(p1, p2);
	}

	public static int dpWay(int[] w, int[] v, int bag) {
		int N = w.length;
		int[][] dp = new int[N + 1][bag + 1];
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 1; rest <= bag; rest++) {
				dp[index][rest] = dp[index + 1][rest];
				if (rest >= w[index]) {
					dp[index][rest] = Math.max(dp[index][rest], v[index] + dp[index + 1][rest - w[index]]);
				}
			}
		}
		return dp[0][bag];
	}

	public static void main(String[] args) {
		int[] weights = { 3, 2, 4, 7 };
		int[] values = { 5, 6, 3, 19 };
		int bag = 11;
		System.out.println(maxValue(weights, values, bag));
		System.out.println(dpWay(weights, values, bag));
	}

}
