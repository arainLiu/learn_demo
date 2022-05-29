package com.nirvana.travel.algorithm.a000_baseSort;

/**
 * 归并排序思想：
 * 将数组二分到最小单位，进行归并，一次变为两个有序数组的归并
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length ==0) {
            return;
        }

    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr,left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] helpArr = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            helpArr[i++] = arr[p1] < arr[p2]? arr[p1 ++] : arr[p2++];
        }

        while (p1 <= mid) {
            helpArr[i++] = arr[p1 ++];
        }
        while (p2 <= right) {
            helpArr[i++] = arr[p2 ++];
        }

        for (int j = 0; j < helpArr.length; j++) {
            arr[left+j] = helpArr[i];
        }
    }

}
