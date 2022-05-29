package com.nirvana.travel.algorithm.a000_baseSort;

/**
 * @author arainliu
 * @date 2022/1/2
 */
public class SelectSort {

  public static void main(String[] args) {
    int[] arr = {11, 3,5,6,2,9,7,8,10};
    new SelectSort().selectionSort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }


  private void selectionSort(int[] arr) {

    for (int i = 0; i < arr.length - 1; i ++) {

      int minIndex = i;
      for (int j = i+1; j < arr.length; j ++) {
        minIndex = arr[j] < arr[minIndex] ? j : minIndex;
      }
      swap(arr, i, minIndex);
    }
  }

  private  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
