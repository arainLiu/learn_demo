package com.nirvana.travel.leetcode.t_00_100.t_074_setZeroes;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arainliu
 * @date 2024/3/19
 */
public class Solution2 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        final List<Integer> integers = new Solution2().spiralOrder(matrix);
        System.out.println(JSON.toJSONString(integers));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        /**
         * 思路：定义好往各个方向前进行和列的变化
         */
        int rlen = matrix.length;
        int coLen = matrix[0].length;

        int total = rlen * coLen;//总元素个数
        List<Integer> resList = new ArrayList<>();

        int[] rowDirect = new int[]{0, 1, 0, -1};//节点前进 行的变化,向右0 ，向下 +1，向左 +0，向上 -1
        int[] coDirect = new int[]{1, 0, -1, 0};
        int index = 0;//rowDirect,coDirect下标，记录最开始的方向索引为0，右 0，下1，左2，上3
        boolean[][] visited = new boolean[rlen][coLen];
        int row =0;
        int col = 0;

        while (resList.size() < total) {
            resList.add(matrix[row][col]);
            visited[row][col] = true;//记录已经访问到的节点
            int nextRow = row + rowDirect[index];
            int nextCol = col + coDirect[index];
            if (nextRow < rlen && nextRow >=0
                    && nextCol < coLen && nextCol >=0
                    && visited[nextRow][nextCol] != true) {
                row = nextRow;
                col = nextCol;
            } else {
                index = (index+1)%4;
                row = row + rowDirect[index];
                col = col + coDirect[index];
            }
        }

        return resList;
    }
}
