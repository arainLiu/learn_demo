package com.nirvana.travel.zuoshen.training_1.class05;

public class Code01_Manacher {

	public static int manacher(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = manacherString(s);
		// 回文半径的大小
		int[] pArr = new int[str.length];
		int C = -1;
		// 讲述中：R代表最右的扩成功的位置。coding中：最右的扩成功位置的，再下一个位置
		int R = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != str.length; i++) {

			//R第一个违规的位置， i >=R,i在R外,此时至少有一个位置不用验证
			// i位置扩出来的答案，i位置扩的区域，至少是多大。
			// 2*C - i 是 i的对称点
			//将每种情况不用验证的区域设置到pArr
			pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

			//右侧不越界并且左侧不越界的情况下，判断是否可以往外扩大范围
			//代码是一个聚合的代码，可以自己分析一下
			while (i + pArr[i] < str.length && i - pArr[i] > -1) {
				if (str[i + pArr[i]] == str[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	// for test
	public static int right(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = manacherString(s);
		int max = 0;
		for (int i = 0; i < str.length; i++) {
			int L = i - 1;
			int R = i + 1;
			while (L >= 0 && R < str.length && str[L] == str[R]) {
				L--;
				R++;
			}
			max = Math.max(max, R - L - 1);
		}
		return max / 2;
	}

	// for test
	public static String getRandomString(int possibilities, int size) {
		char[] ans = new char[(int) (Math.random() * size) + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
		}
		return String.valueOf(ans);
	}

	public static void main(String[] args) {
		int possibilities = 5;
		int strSize = 20;
		int testTimes = 5000000;
		System.out.println("test begin");
		for (int i = 0; i < testTimes; i++) {
			String str = getRandomString(possibilities, strSize);
			if (manacher(str) != right(str)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("test finish");
	}

}
