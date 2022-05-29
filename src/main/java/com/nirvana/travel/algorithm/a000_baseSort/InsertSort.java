package com.nirvana.travel.algorithm.a000_baseSort;

/**
 * @author arainliu
 * @date 2022/1/2
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] arr = {11, 3,5,6,2,9,7,8,10};
    new InsertSort().insertSort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  private void insertSort(int[] arr) {

    for (int i = 1; i < arr.length; i ++) {

      for (int j=i - 1; j >=0; j--) {
        if (arr[j] > arr[j+1]) {
          swap(arr, j, j+1);
        }
      }
    }
  }

  private  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


}
