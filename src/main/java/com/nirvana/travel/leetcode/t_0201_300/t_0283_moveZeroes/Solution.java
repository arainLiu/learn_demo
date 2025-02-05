package com.nirvana.travel.leetcode.t_0201_300.t_0283_moveZeroes;

import com.alibaba.fastjson.JSON;
import com.oracle.tools.packager.mac.MacAppBundler;

import java.time.zone.ZoneRules;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author arainliu
 * @date 2024/2/21
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return ;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++]=nums[i];
            }
        }

        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

//    public static void moveZeroes(int[] nums) {
//        if (nums.length == 1) return ;
//
//        int zeroIndex = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                int tmp = nums[i];
//                nums[i] = nums[zeroIndex];
//                nums[zeroIndex++] = tmp;
//            }
//        }
//    }

//    public void moveZeroes(int[] nums) {
//        if (nums.length == 1) return ;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                for (int j = i+1; j < nums.length; j++) {
//                    if (nums[j] != 0) {
//                        swap(nums, i, j);
//                        break;
//                    }
//                }
//            }
//        }
//    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
