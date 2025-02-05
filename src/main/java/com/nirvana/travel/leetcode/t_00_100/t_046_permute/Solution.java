package com.nirvana.travel.leetcode.t_00_100.t_046_permute;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arainliu
 * @date 2024/2/26
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        final List<List<Integer>> permute = new Solution().permute(arr);
        System.out.println(JSON.toJSONString(permute));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        dfs(res, output, 0, nums.length);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> output, int index, int num) {
        if (index == num) {
            res.add(new ArrayList<>(output));
        }

        for (int i = index; i < num; i++) {
            swap(output, i, index);//将i位置的数固定到index位置
            dfs(res, output, index + 1, num);
            swap(output, i, index);//将交换的元素复原，作为上一层的原始参数
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
}
