package com.nirvana.travel.algorithm.sort;

/**
 * @author arainliu
 * @date 2024/1/28
 */
public class SortUtils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int x : arr) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void swapBit(int[] arr, int i, int j) {

    }
}
