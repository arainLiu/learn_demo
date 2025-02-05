package com.nirvana.travel.leetcode.t_0201_300.t_240_searchMatrix;

/**
 * @author arainliu
 * @date 2024/3/20
 */
public class Solution {

    public boolean searchMatrixBinary(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) return true;
        }

        return false;
    }

    private int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left<right) {
            int mid = left + (right - left)/2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num>target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public boolean searchMatrixZ(int[][] matrix, int target) {
        int rowlen = matrix.length;
        int colen = matrix[0].length;

        int row = 0, col = colen -1;
        while (row < rowlen && col>=0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num < target) {
                row ++;//当前位置小，row+1,查找更大值
            } else {
                col --;//往左寻找更小数值
            }
        }

        return false;
    }
}
