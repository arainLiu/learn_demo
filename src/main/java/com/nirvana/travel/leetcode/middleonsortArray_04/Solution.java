package com.nirvana.travel.leetcode.middleonsortArray_04;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2020/12/29
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 */
public class Solution {

  public static void main(String[] args) {
    int[] num1 = new int[]{1,2,4,5,7,9};
    int[] num2 = new int[]{3,4,6,8,10,12};
    System.out.println(findMedianSortedArrays(num1, num2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int sum1 = nums1.length;
    int sum2 = nums2.length;
    int[] nums3 = new int[sum1 + sum2];

    int i=0,j=0,k=0;
    while (i<sum1 && j<sum2) {
      if (nums1[i] < nums2[j]) {
        nums3[k++] = nums1[i++];
      } else {
        nums3[k++] = nums2[j++];
      }
    }
    //将nums1中剩余元素移入到nums3中
    while (i < sum1) {
      nums3[k++] = nums1[i++];
    }

    while (j < sum2) {
      nums3[k++] = nums2[j++];
    }

    System.out.println();
    for (int x=0;x <nums3.length;x++) {
      System.out.print(nums3[x] + " ");
    }
    System.out.println();

    double middleNum = 0;
    int midIndex = nums3.length / 2;
    if (nums3.length % 2==0) {
      middleNum = ((double) nums3[midIndex] + (double) nums3[midIndex - 1])/2;
    } else {
      middleNum = nums3[midIndex];
    }

    return middleNum;
  }
}
