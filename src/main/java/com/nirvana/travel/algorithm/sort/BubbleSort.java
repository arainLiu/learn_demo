package com.nirvana.travel.algorithm.sort;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2020/12/28
 * 冒泡排序：
 *
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {3,2,4,6, 1,8,9,7};
    bubbleSort(arr);
    StringBuffer sb = new StringBuffer();
    for (int x : arr) {
      sb.append(x).append(" ");
    }
    System.out.println(sb.toString());
  }

  public static void bubbleSort(int[] arr) {

    int length = arr.length;
    for (int i =0;i < length; i++) {

      for (int j = 0; j < length - i -1; j++) {
        if (arr[j] > arr[j+1]) {
          swap(arr, j, j+1);
        }
      }
    }
  }

  public static void swap(int[] arr, int i , int j) {
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
  }
}
