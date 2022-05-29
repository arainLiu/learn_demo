package com.nirvana.travel.algorithm.sort.quicksort;

import static com.nirvana.travel.zuoshen.base.class03.Code03_PartitionAndQuickSort.*;

/**
 * @author arainliu
 * @date 2022/2/23
 */
public class QuickSort {

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    /**
     * 随机快排
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return ;
        }

        //找到随机数进行划分
        int randomPos = L + (int) Math.random() * (R-L+1);
        //交换随机值和最右侧的数值，
        swap(arr, randomPos, R);
        //进行🇳🇱划分，找出相等的左右边界
        int[] equalArea = netherlandsFlag(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);

    }

    private static int[] netherlandsFlag(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{1, 1};
        }

        //以right为基准进行对比，小于 r的放在左边， 大于R的放在右边，相等的放在中间
        //定义左右边界L/R
        int less = left - 1; //< 区域 右边界
        int more = right;// > 区域左边界

        int index = left;
        /*
        * 1.如果当前值 = right, index ++
        * 2. 如果当前值 < right , 小于区域右扩，less++, index++
        * 3. 如果当前值 > right, 大于区域左扩 ，more --, index不变
        * */
        while (index < more) {
            if (arr[index] == arr[right]) {
                index ++;
            }
            else if (arr[index] < arr[right]){
                //此时当前值和左边的下一个位置的值交换，左边界右扩，当前位置+1
                swap(arr, index++, ++ less);
            } else {
                //arr[index] > arr[right],当前值和有边界的左一个值进行交互，右边界做扩，当前位置不变，因为换过来的值还没有比较
                swap(arr, index, --more);
            }
        }
        //等于arr[right]的第一个位置和right交换
        swap(arr, more, right);
        //此时,返回
        return new int[]{less + 1, more};

    }


    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
