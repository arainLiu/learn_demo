package com.nirvana.travel.zuoshen.base.class12;

import java.util.HashMap;
import java.util.Map;

public class Code09_CoinsWay {

	// arr中都是正数且无重复值，返回组成aim的方法数
	public static int ways(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;//方法数
		}
		return process(arr, 0, aim);
	}

	// 可以自由使用arr[index...]所有的的面值，每一种面值都可以使用任意张
	// 组成rest这么多钱，有多少中方法，返回方法数 （1 , 6）
	public static int process(int[] arr, int index, int rest) {

		//rest >=0
		if (index == arr.length) { // 无面值的时候
			return rest == 0 ? 1 : 0;
		}
		// 有面值的时候
		int ways = 0;

		// 当前有货币， arr[index] 当钱面值
		//  此处保证rest不会小于0
		for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {//从第一种面值开始，从第一种面值有0张开支，每次枚举找到后面面值可以有的解法，一直枚举到有最大张数，
			ways += process(arr, index + 1, rest - zhang * arr[index]);
		}
		return ways;
	}



	// arr中都是正数且无重复值，返回组成aim的方法数
	public static int ways_cache(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;//方法数
		}

//		Map<String, Integer> map = new HashMap<>();
		// index = 3, rest = 900, 记为 "3_900" int

		int[][] dp = new int[arr.length+1][aim+1];
		for(int i = 0; i< dp.length; i++) {
			for(int j = 0; j < dp[0].length; j ++) {
				dp[i][j] = -1;
			}
		}

		return process_cache(arr, 0, aim, dp);
	}

	// 如果index和rest的参数组合是没有算过的，那么dp[index][rest]==-1
	// 如果index和rest的参数组合是算过的，那么dp[index][rest] > -1
	public static int process_cache(int[] arr, int index, int rest, int[][] dp) {

		if (dp[index][rest]==-1) {
			return dp[index][rest];
		}

		//rest >=0
		if (index == arr.length) { // 无面值的时候
			dp[index][rest] = rest == 0 ? 1 : 0;
			return dp[index][rest];
		}
		// 有面值的时候
		int ways = 0;

		// 当前有货币， arr[index] 当钱面值
		//  此处保证rest不会小于0
		for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {//从第一种面值开始，从第一种面值有0张开支，每次枚举找到后面面值可以有的解法，一直枚举到有最大张数，

			ways += process_cache(arr, index + 1, rest - zhang * arr[index], dp);
		}
		dp[index][rest] = ways;
		return ways;
	}

	public static int waysdp(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int N = arr.length;
		int[][] dp = new int[N + 1][aim + 1];
		dp[N][0] = 1;//index == arr.length, 最后一行rest=0时是1，其他都是0

		//不考虑枚举值的动态规划过程
//		for (int index = N - 1; index >= 0; index--) { // 大顺序 从下往上，从第N-1行开始，依次往上去递归
//			for (int rest = 0; rest <= aim; rest++) {
//				int ways = 0;
//				for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {//从第一种面值开始，从第一种面值有0张开支，每次枚举找到后面面值可以有的解法，一直枚举到有最大张数，
//					ways += dp[index + 1][rest - zhang * arr[index]];
//				}
//				dp[index][rest] = ways;
//			}
//		}

		for (int i = N - 1; i >= 0; i--) { // 大顺序 从下往上，从第N-1行开始，依次往上去递归
			for (int rest = 0; rest <= aim; rest++) {
				dp[i][rest] = dp[i + 1][rest];//当前的
				if (rest - arr[i] >= 0) {
					dp[i][rest] += dp[i][rest - arr[i]];
				}
			}
		}
		return dp[0][aim];
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 1 };
		int sum = 350;
		System.out.println(ways(arr, sum));
		System.out.println(waysdp(arr, sum));
	}

}
