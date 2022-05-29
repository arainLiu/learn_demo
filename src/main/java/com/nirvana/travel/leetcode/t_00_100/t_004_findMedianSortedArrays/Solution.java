package com.nirvana.travel.leetcode.t_00_100.t_004_findMedianSortedArrays;

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

        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] ansArr = new int[length1 + length2];

        int i = 0, j = 0, index = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] > nums2[j]) {
                ansArr[index++] = nums2[j++];
            } else {
                ansArr[index++]=nums1[i++];
            }
        }

        while (i < length1) {
            ansArr[index++]=nums1[i++];
        }
        while (j < length2) {
            ansArr[index++] = nums2[j++];
        }


        double ans = 0;
        int sumLength = length1 + length2;
        if (sumLength%2 == 1) {//长度为奇数
            ans = ansArr[sumLength/2];
        } else {//长度为偶数
            ans = ((double)ansArr[(sumLength-1)/2] + (double)ansArr[(sumLength-1)/2 +1])/2;
        }

        return ans;
    }

//    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
//
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        double ans = 0;
//        int sumLength = length1 + length2;
//        if (sumLength == 1) return nums1.length == 0?nums2[0]:nums1[0];
//
//        if (sumLength%2 == 1) {//长度为奇数
//            ans = findMid(nums1, nums2, sumLength/2, sumLength/2);
//        } else {//长度为偶数
//            ans = findMid(nums1, nums2, (sumLength-1)/2, (sumLength-1)/2 +1);
//        }
//
//        return ans;
//    }
//
//    private double findMid(int[] nums1, int[] nums2, int left, int right) {
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//
//        int i = 0, j = 0;
//        int midleft = 0;
//        int midRight = 0;
//        int index = 0;
//        while((i < length1 || j < length2) && index <= left) {
//
//            if (index == left) {
//
//                break;
//            }
//            if (nums1[i] >= nums2[j]) {
//                i++;
//            } else {
//                j++;
//            }
//            index ++;
//        }
//    }
}
