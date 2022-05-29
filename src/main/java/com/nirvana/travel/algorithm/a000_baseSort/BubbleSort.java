package com.nirvana.travel.algorithm.a000_baseSort;

/**
 * @author arainliu
 * @date 2021/12/31
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {3,2,6,5,8,7,9,11,4};
    new BubbleSort().bubbleSort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }

  }

  /**
   * 每一轮比较确定一个最大值的位置，放到数组最后
   *  具体是一共进行n-1轮比较，
   *  每次比较都进行移动
   * @param arr
   */
  public void bubbleSort(int[] arr) {
    int length = arr.length;
    for (int i = length - 1; i >0; i--) {
      for (int j = 0; j < i; j ++) {
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
