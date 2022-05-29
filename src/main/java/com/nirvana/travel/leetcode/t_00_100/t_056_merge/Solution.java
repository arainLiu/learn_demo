package com.nirvana.travel.leetcode.t_00_100.t_056_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author arainliu
 * @date 2021/12/27
 */
public class Solution {

  public int[][] merge(int[][] intervals) {

    if (intervals.length == 0) {
      return new int[0][2];
    }

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    List<int[]> mergedList = new ArrayList<>();
    for (int i = 0; i<=intervals.length - 1; i ++) {
      int L = intervals[i][0];
      int R = intervals[i][1];
      int size = mergedList.size();
      if (mergedList.size() ==0 || mergedList.get(size - 1)[1] < L) {
        mergedList.add(new int[]{L,R});
      } else {
        mergedList.get(size - 1)[1] = Math.max(mergedList.get(size - 1)[1], R);
      }
    }

    return mergedList.toArray(new int[mergedList.size()][]);
  }

}
