package com.nirvana.travel.leetcode.t_00_100.t_11_maxArea;

/**
 * @author arainliu
 * @date 2022/5/24
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution2().maxArea(height));
    }

    public int maxArea(int[] height) {

        int ans = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            ans = Math.max(ans, (j-i)*Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j --;
            } else {
                i++;
            }
        }
        return ans;
    }

}
