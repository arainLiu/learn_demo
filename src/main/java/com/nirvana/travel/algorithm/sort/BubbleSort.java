package com.nirvana.travel.algorithm.sort;

/**
 * @author arainliu
 * @date 2020/12/28
 * 冒泡排序：
 *
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {3,2,4,6, 1,8,9,7};
    bubbleSort(arr);
    SortUtils.printArr(arr);
  }

  public static void bubbleSort(int[] arr) {
    if (arr.length == 0 || arr.length == 1) return;

    //0...n-1
    //0...n-2
    //0...n-3
    //外层循环n次，内层循环[0...i]
    for (int i = arr.length -1 ; i > 0; i --) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j+1]) {
          SortUtils.swap(arr, j, j+1);
        }
      }
    }

  }

}
