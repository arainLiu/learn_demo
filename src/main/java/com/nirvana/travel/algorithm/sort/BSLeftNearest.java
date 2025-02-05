package com.nirvana.travel.algorithm.sort;

/**
 * @author arainliu
 * 在一个有序数组中，找>=某个数最左侧的位置
 * @date 2024/2/1
 */
public class BSLeftNearest {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1, 2, 4, 5, 5, 5, 6, 7, 7,8, 8, 9};
        final int i = nearestIndex(arr, 5);
        System.out.println(i);
    }

    // 1 1 2 4 5 5 5 6 7 7 8 8 9   value 5
    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {

        int index = -1;
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + ((right-left)>>1);
            if (arr[mid] >= value) {
                index = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
