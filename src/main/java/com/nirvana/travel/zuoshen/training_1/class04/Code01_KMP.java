package com.nirvana.travel.zuoshen.training_1.class04;

public class Code01_KMP {


	//整体O(n)
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] str = s.toCharArray();
		char[] match = m.toCharArray();
		int x = 0; // str中当前比对的位置
		int y = 0; //match中当前比对到的位置

		//M M<=N, O(?)
		int[] next = getNextArray(match);//模式串match next[i] match中i之前的字符串match[0..i-1]

		//while必须是O(n)
		// x:0~N, y:0~N,
		while (x < str.length && y < match.length) {
			if (str[x] == match[y]) {//字符相等
				x++;
				y++;
			} else if (next[y] == -1) {//y已经来到0位置，y==0
				x++;
			} else { //其他情况y回溯到next[y]的位置
				y = next[y];
			}
		}

		// 1）x越界，没有越界，返回 -1
		// 2) x没有越界，y没有越界，返回对应的开头的index
		// 3) x越界，y越界，返回对应的开头的index
		return y == match.length ? x - y : -1;
	}

	//next数组
	// M  O(M)
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		//0,1位置的值是固定的
		next[0] = -1;
		next[1] = 0;
		int i = 2;
		// cn代表，cn位置的字符，是当前和i-1位置比较的字符
		// i -1 情况下，match串前缀和后缀匹配的最大值的数值
		//也表示i-1在next数组中下一个跳转的位置
		int cn = 0;

		//i位置在next数组中的值是match数组上0~i-1上的前缀和后缀匹配的最大值，不包括i位置
		//while循环发生的次数不会高于2M次

		while (i < next.length) {

			if (ms[i - 1] == ms[cn]) {
//				next[i] = cn + 1;
//				i ++;
//				cn ++;
				next[i++] = ++cn;
			} else if (cn > 0) {//说明能够继续往前条
				cn = next[cn];
			} else {//说明没有相同的前缀和后缀可以匹配，设置为0
				next[i++] = 0;
			}
		}
		return next;
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
		int matchSize = 5;
		int testTimes = 5000000;
		System.out.println("test begin");
		for (int i = 0; i < testTimes; i++) {
			String str = getRandomString(possibilities, strSize);
			String match = getRandomString(possibilities, matchSize);
			if (getIndexOf(str, match) != str.indexOf(match)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("test finish");
	}

}
