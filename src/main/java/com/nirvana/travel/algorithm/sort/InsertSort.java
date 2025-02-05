package com.nirvana.travel.algorithm.sort;

/**
 * @author arainliu
 * @date 2020/10/19
 *
 *
 */
public class InsertSort {


  public static void main(String[] args) {
    int[] arr = new int[]{10,2,5,7,5,6,8,9,20,1,3};
    insertSort(arr);
    for (int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
  }

  //从0...i上有序，i+1...n-1上无需
  private static void insertSort2(int[] arr) {
    if (arr.length < 2) return;

    for (int i = 0; i < arr.length-1; i++) {
      for (int j = i; j >= 0 && arr[j] > arr[j+1]; j--) {
        SortUtils.swap(arr, j, j+1);
      }
    }
  }







  /**
   * 插入排序：可以将一个数组分为有序和无序部分，a[0,i-1],a[i...n-1],每次从后半部分中取出temp=a[i],
   * 和前面a[0,i-1]从后往前依次比较,将大于a[i]的数据依次后移一个位置，
   * 直到找到a[preIndex]<temp,将temp赋值给a[preIndex+1]
   * @param arr
   */
  private static void insertSort(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    for (int i=0;i< arr.length-1 ; i++) {
      int temp = arr[i+1];

      int preIndex = i ;
      while (preIndex >= 0 && temp < arr[preIndex]) {
        arr[preIndex + 1] = arr[preIndex];
        preIndex --;
      }

      arr[preIndex+1] = temp;
    }
  }
}
