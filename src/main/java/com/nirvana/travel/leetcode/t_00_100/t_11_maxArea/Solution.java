package com.nirvana.travel.leetcode.t_00_100.t_11_maxArea;

import org.apache.lucene.codecs.LegacyDocValuesIterables;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 */
public class Solution {

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;

    int ans=0;
    while (left < right) {
      ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right --;
      }
    }

    return ans;
  }

}
