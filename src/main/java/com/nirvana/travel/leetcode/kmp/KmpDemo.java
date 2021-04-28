package com.nirvana.travel.leetcode.kmp;

/**
 * @author arainliu
 * @date 2021/1/26
 */
public class KmpDemo {

  public static void main(String[] args) {
    String str = "ATGTGAGCTGGTGTGTGCFAA";
    String pattern = "GTGTGCF";
    int index = kmp(str, pattern);
    System.out.println("首次出现位置：" + index);
  }

  /**
   * 暴力破解法
   *
   * @param ts 主串
   * @param ps 模式串
   * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
   */

  public static int bf(String ts, String ps) {

    char[] t = ts.toCharArray();
    char[] p = ps.toCharArray();
    int i = 0; // 主串的位置
    int j = 0; // 模式串的位置
    while (i < t.length && j < p.length) {
      if (t[i] == p[j]) { // 当两个字符相同，就比较下一个
        i++;
        j++;
      } else {
        i = i - j + 1; // 一旦不匹配，i后退
        j = 0; // j归0
      }
    }
    if (j == p.length) {
      return i - j;
    } else {
      return -1;
    }
  }

  /**
   * KMP算法：最长可匹配后缀子串和最长可匹配前缀子串
   */

  // KMP算法主体逻辑。str是主串，pattern是模式串
  public static int kmp(String str, String pattern) {
    //预处理，生成next数组
    int[] next = getNexts(pattern);
    int j = 0;//主循环，遍历主串字符
    for (int i = 0; i < str.length(); i++) {
      while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
        //遇到坏字符时，查询next数组并改变模式串的起点
        j = next[j];
      }

      if (str.charAt(i) == pattern.charAt(j)) {
        j++;
      }
      if (j == pattern.length()) {
        //匹配成功，返回下标
        return i - pattern.length() + 1;
      }
    }
    return -1;
  }

  // 生成Next数组
  private static int[] getNexts(String pattern) {
    int[] next = new int[pattern.length()];
    int j = 0;
    for (int i = 2; i < pattern.length(); i++) {
      while (j != 0 && pattern.charAt(j) != pattern.charAt(i - 1)) {
        //从next[i+1]的求解回溯到next[j]
        j = next[j];
      }

      if (pattern.charAt(j) == pattern.charAt(i - 1)) {
        j++;
      }
      next[i] = j;
    }
    return next;
  }

}
