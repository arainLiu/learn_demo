package com.nirvana.travel.leetcode.t_0501_0600.t_0560_subarraySum;

import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2024/2/26
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,3,4,5,2,3,1,6};
        System.out.println(new Solution().subarraySumHash(arr, 7));
    }


    public int subarraySum(int[] nums, int k) {

        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }

        return count;
    }

    /**
     * 思路就是 sum[i]-sum[j]=k， i>=j的情况下，[i...j]之和==k,用哈希记录sum[j]的值和匹配的数量
     * 比较难理解的点是，x>y时， 可能出现preSum[x]==preSum[y]，这种情况下，说明[x...y-1]上元素和为0
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumHash(int[] nums, int k) {

        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);//当sum[i]-k==0,也是一次匹配
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSumMap.containsKey(sum - k)) {
                count += preSumMap.get(sum - k);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
