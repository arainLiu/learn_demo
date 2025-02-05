package com.nirvana.travel.algorithm.sort;

/**
 * @author arainliu
 * @date 2020/10/17
 *
 * 选择排序算法
 *
 */
public class SelectSort {

  public static void main(String[] args) {
    int[] arr = new int[]{10,2,5,7,6,8,9,20,1,3};
    selectSort(arr);
    for (int i=0;i<arr.length;i++) {
      System.out.print(arr[i] + " ");
    }
  }


  private static void selectSort(int[] arr) {

    if (arr.length ==0 || arr.length == 1) return;

    //从[0..n-1]上一次找到最小值位置，和0位置进行交换
    //从[1...n-1]上找到最小值位置，和1位置交换
    for (int i = 0; i < arr.length-1; i++) {
      //定义最小值位置
      int minIndex = i;
      //从i+1查找最小值位置
      for (int j = i+1; j < arr.length; j++) {
        minIndex = arr[minIndex] > arr[j] ? j : minIndex;
      }

      if (minIndex > i) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
      }
    }
  }
}
