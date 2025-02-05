package com.nirvana.travel.algorithm.sort;

/**
 * @author arainliu
 *
 *  在一个有序数组中，找某个数是否存在
 * @date 2024/2/1
 */
public class BSExist {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,7,9,11, 12,14,16,17};
        final boolean exist = exist(arr, 1);
        System.out.println(exist);
    }

    public static boolean exist(int[] sortedArr, int num) {

        if (sortedArr.length == 0) return false;

        int left = 0;
        int right = sortedArr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >>1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //能执行到这里，说明left == right,取任一个来判断即可
        return sortedArr[left] == num;
    }
}
