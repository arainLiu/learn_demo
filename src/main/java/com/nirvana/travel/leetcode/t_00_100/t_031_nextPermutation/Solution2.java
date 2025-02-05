package com.nirvana.travel.leetcode.t_00_100.t_031_nextPermutation;

import com.alibaba.fastjson.JSON;

/**
 * @author arainliu
 * @date 2023/2/27
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        new Solution2().nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    /**
     *     举例：[1,2,3,6,5| 5,9,8,6,5]
     * next排列：[1,2,3,6,5| 5,9,8,6,5]
     * 首先倒序找到数组中第一个逆行的数， 5<9, 定义i的位置nums[5] = 5,此时 [i+1...len-1]为逆序排列
     * 找到[i+1...len-1]上大于nums[i]的最小值，位置为j，此时 nums[8]=6,交换i，j位置元素，
     *   此时，数组：[1,2,3,6,5| 6,9,8,5 |5]
     * 此时需要[i+1...j]上为降序，9 8 5， 如果想得到下一个排列数，则需要将这三个数改为升序，对[i+1...j]上数字进行逆序
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        int pi = nums.length - 2;//假设从倒数第二个数就是倒序
        while (pi >= 0 && nums[pi] >= nums[pi+1]) {//遍历查到从后往前第一个降序的数字或者数组的第一个元素
            pi --;
        }

        //找到从[pi..len-1]上大于nums[pi]的最小值
        if (pi >= 0) {
            int pj = nums.length - 1;//从最后一个开始找大于pi的最小值,如果不存在，则pj = len - 1;
            while (pj > pi && nums[pj] <= nums[pi]) {
                pj --;
            }
            //交换pi和pj的位置
            swap(nums, pi, pj);
        }

        //将[pi...pj]上元素逆序
        reverse(nums, pi+1);
    }

    public void reverse(int[] nums, int index) {
        int right = nums.length - 1;
        while (index < right) {
            swap(nums, index ++, right --);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tem = nums[a];
        nums[a] = nums[b];
        nums[b] = tem;
    }
}
