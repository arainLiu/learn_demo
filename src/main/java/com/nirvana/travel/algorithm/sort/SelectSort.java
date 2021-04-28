package com.nirvana.travel.algorithm.sort;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2020/10/17
 *
 * 选择排序算法
 *
 */
public class SelectSort {

  public static void main12(String[] args) {
    int[] arr = new int[]{10,2,5,7,6,8,9,20,1,3};
    selectSort(arr);
    for (int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
  }


  private static void selectSort(int[] arr) {
    if (arr.length == 0)
      return;

    //每次循环从a[i+1...n]中找出最小值，放到前半部分有序数组最后
    for (int i = 0;i < arr.length; i ++) {
      int minValueIndex = i;
      //arr[0...i]有序，每次循环找出arr[i+1...n]<arr[i]的下标j，将arr[i]和arr[j]进行交换位置
      for (int j=i+1; j < arr.length; j ++) {
        if (arr[j] < arr[minValueIndex]) {
          minValueIndex = j;
        }
      }

      if (i != minValueIndex) {
        int temp = arr[i];
        arr[i] = arr[minValueIndex];
        arr[minValueIndex] = temp;
      }

      for (int x=0;x < arr.length;x++) {
        System.out.print(arr[x] + " ");
      }
      System.out.println();
      System.out.println("=================");

    }
  }
}
