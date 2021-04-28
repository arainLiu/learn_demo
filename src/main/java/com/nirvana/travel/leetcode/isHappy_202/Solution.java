package com.nirvana.travel.leetcode.isHappy_202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/27
 *
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

  public boolean isHappy(int n) {
    Set<Integer> sumSet = new HashSet<>();

    while (n != 1 && !sumSet.contains(n)) {
      sumSet.add(n);
      n = getNextSum(n);
    }

    return n == 1;
  }

  public boolean isHappy2(int n) {

    int slow = n;
    int fast = getNextSum(n);
    while (fast != 1 && slow != fast) {
      slow = getNextSum(slow);
      fast = getNextSum(getNextSum(fast));
    }

    return fast == 1;
  }

  public int getNextSum(int n) {
    int sum = 0;

    while (n>0) {
      int d = n % 10;//取末尾数字
      n = n/10; //n在数位上减一
      sum += d * d;
    }

    return sum;
  }

}
