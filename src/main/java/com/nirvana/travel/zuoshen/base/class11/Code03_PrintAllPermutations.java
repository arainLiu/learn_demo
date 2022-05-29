package com.nirvana.travel.zuoshen.base.class11;

import java.util.ArrayList;
import java.util.List;

public class Code03_PrintAllPermutations {

	//字符串全排列（不去重）
	public static ArrayList<String> permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		if (str == null || str.length() == 0) {
			return res;
		}
		char[] chs = str.toCharArray();
		process(chs, 0, res);
		return res;
	}

	//str[0...i-1]已经做好决定
	//str[i...]都有机会来到i位置
	//i 为终止位置
	public static void process(char[] str, int i, ArrayList<String> res) {
		if (i == str.length) {
			res.add(String.valueOf(str));
		}
		//如果i没有终止，从i...所有都可以来到i的位置
		for (int j = i; j < str.length; j++) {//尝试j i后面所有字符都有机会
			swap(str, i, j);
			process(str, i + 1, res);
			swap(str, i, j);//恢复原来现场
		}
	}

	//字符串全排列，去重
	public static ArrayList<String> permutationNoRepeat(String str) {
		ArrayList<String> res = new ArrayList<>();
		if (str == null || str.length() == 0) {
			return res;
		}
		char[] chs = str.toCharArray();
		process2(chs, 0, res);
		return res;
	}

	//str[0...i-1]已经做好决定
	//str[i...]都有机会来到i位置
	//i 为终止位置，str当前的样子就是一种结果，加到ans中去
	//分支限界法
	public static void process2(char[] str, int i, ArrayList<String> res) {
		if (i == str.length) {
			res.add(String.valueOf(str));
		}
		//思路：当一个字符在当前分支中已经出现过，直接跳过，没有出现过，才走之路
		boolean[] visit = new boolean[26]; // visit[0 1 .. 25] 判断从a-z的字母是否都出现过
		for (int j = i; j < str.length; j++) {
			if (!visit[str[j] - 'a']) {//判断当前字符是否已经在本次递归中出现
				visit[str[j] - 'a'] = true;
				swap(str, i, j);
				process2(str, i + 1, res);
				swap(str, i, j);
			}
		}
	}

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

	public static void main(String[] args) {
		String s = "aac";
		List<String> ans1 = permutation(s);
		for (String str : ans1) {
			System.out.println(str);
		}
		System.out.println("=======");
		List<String> ans2 = permutationNoRepeat(s);
		for (String str : ans2) {
			System.out.println(str);
		}

	}

}
