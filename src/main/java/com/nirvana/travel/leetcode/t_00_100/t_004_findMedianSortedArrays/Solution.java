package com.nirvana.travel.leetcode.t_00_100.t_004_findMedianSortedArrays;

import org.checkerframework.checker.units.qual.Length;

/**
 * @author arainliu
 * @date 2022/5/21
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    /**
     * 思路：
     * 两分法，转化为第k小数的问题,每次选出k/2个最小数进行排除,k = k - k/2
     * 当k == 1，或者某个组数未排除数量==0，可以直接返回结果
     *
     *  nums1,nums2 取
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int len = len1 + len2;

        //当两数组元素总数量为偶数时，中位数为中间两个数之和/2.0，即第 (len+1)/2 和 (len + 2)/2
        if (len % 2 == 0) {
            return (findKthNum(nums1, 0, len1 - 1, nums2, 0,len2-1, (len + 1)/2)
                    + findKthNum(nums1, 0, len1 - 1, nums2, 0,len2-1, (len + 2)/2))/2.0;
        } else {
            //当为奇数时，中位数为中间的那个元素，即第 (len+1)/2
            return findKthNum(nums1, 0, len1 - 1, nums2, 0,len2-1, (len + 1)/2);
        }
    }

    private int findKthNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        //统一把小的数组放在前面，保证nums1先被划分完
        if (len1 > len2) return findKthNum(nums2, start2, end2, nums1, start1,end1, k);
        //如果nums1已经无剩余元素，
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int index1 = start1 + Math.min(len1, k)/2 - 1;
        int index2 = start2 + Math.min(len2, k)/2 - 1;
        if (nums1[index1] > nums2[index2]) {//放弃 nums2 0...index2
            return findKthNum(nums1, start1, end1, nums2, index2 + 1, end2, k - (index2 - start2 + 1));
        } else {//放弃 nums1 0...index1
            return findKthNum(nums1, index1 + 1, end1, nums2, start2,end2, k - (index1 - start1 + 1));
        }
    }
}
