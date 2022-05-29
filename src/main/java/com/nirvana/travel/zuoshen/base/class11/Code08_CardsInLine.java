package com.nirvana.travel.zuoshen.base.class11;


public class Code08_CardsInLine {

	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	//在i..j上，先手拿获取到到最大数字是多少
	public static int f(int[] arr, int i, int j) {
		if (i == j) {//只剩一张牌的时候 base case
			return arr[i];
		}
		//先手拿左侧牌，然后在[i+1, j]上以后手拿到的最大牌
		//先手拿右侧牌，然后再[i, j-1]上以后手拿牌拿到的最大牌
		//选择最大值
		return Math.max(arr[i] + s(arr, i + 1, j)
			, arr[j] + s(arr, i, j - 1));
	}

	//在i..j上，后手拿获取到到最大数字是多少
	public static int s(int[] arr, int i, int j) {
		if (i == j) {
			return 0;
		}
		//此时作为后手，先手已经把i,j中最大值选走了，被动能选到的只会是 max[i+1/j]或者max[i/j-1]中的最小值
		return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}

	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];

		for(int i = 0; i< arr.length; i++) {
			f[i][i] = arr[i];//将暴力递归中的i==j的条件写入
			//因为S上都是0，默认数组中元素为0，不需要再次赋值
		}

		//s[i][i] = 0;
		for (int i = 1; i < arr.length; i++) {
			int L = 0;
			int R = i;
			while (L < arr.length && R < arr.length) {
				f[L][R] = Math.max(arr[L] + s[L + 1][R]
					, arr[R] + s[L][R - 1]);
				s[L][R] = Math.min(f[L + 1][R], f[L][R-1]);
				L++;
				R++;
			}
		}



//		for (int j = 0; j < arr.length; j++) {
//			f[j][j] = arr[j];
//			for (int i = j - 1; i >= 0; i--) {
//				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
//				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
//			}
//		}
		return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 1 ,40,30,59,10};
		System.out.println(win1(arr));
		System.out.println(win2(arr));

	}

}
