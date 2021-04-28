package com.nirvana.travel.leetcode.revert_int_07;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @author liupengyu10336@hellobike.com
 * @date 2021/2/19
 */
public class solution {

  public static void main(String[] args) {

    int x = -2147483648;
    System.out.println(reverse(x));
  }

  public static int reverse(int x) {
    int ans = 0;
    while (x != 0) {
      if ((ans * 10) / 10 != ans) {
        ans = 0;
        break;
      }
      ans = ans * 10 + x % 10;
      x = x / 10;
    }
    return ans;
  }

}
