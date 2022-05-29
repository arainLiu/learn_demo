package com.nirvana.travel.bytedance.maxArea_11;

/**
 * @author arainliu
 * @date 2021/5/14
 */
public class Solution {

  public int maxArea(int[] height) {

    int left = 0;
    int right = height.length -1;
    int ans =0;
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      ans = Math.max(ans, area);

      if (height[left] < height[right]) {
        left ++;
      } else {
        right --;
      }
    }

    return ans;
  }

}
