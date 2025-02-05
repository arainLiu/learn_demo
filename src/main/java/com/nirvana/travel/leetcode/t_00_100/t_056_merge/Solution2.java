package com.nirvana.travel.leetcode.t_00_100.t_056_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author arainliu
 * @date 2024/3/15
 */
public class Solution2 {

    public int[][] merge(int[][] intervals) {

        List<int[]> mergeList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        for (int i = 0; i < intervals.length; i++) {

            int l = intervals[i][0];
            int r = intervals[i][1];
            int size = mergeList.size();
            if (mergeList.isEmpty() || mergeList.get(size-1)[1] < l) {//说明连不起来
                mergeList.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                mergeList.get(size-1)[1] = Math.max(mergeList.get(size-1)[1], r);
            }
        }

        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
