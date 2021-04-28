package com.nirvana.travel.leetcode.arr2merge_88;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/6
 */
public class Solution {

  public static void main(String[] args) {
    int[] arr = new int[10];
    arr[0] = 1;
    arr[1] = 5;
    arr[2] = 6;
    arr[3] = 8;
    int[] arr2 = new int[]{3,5,7,9};

    merge(arr, 4, arr2, 3);
    for (int i : arr) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = 0, p2 = 0;
    int[] sorted = new int[m + n];
    int cur;
    while (p1 < m || p2 < n) {
      if (p1 == m) {
        cur = nums2[p2++];
      } else if (p2 == n) {
        cur = nums1[p1++];
      } else if (nums1[p1] < nums2[p2]) {
        cur = nums1[p1++];
      } else {
        cur = nums2[p2++];
      }
      sorted[p1 + p2 - 1] = cur;
    }
    for (int i = 0; i != m + n; ++i) {
      nums1[i] = sorted[i];
    }
  }
}
