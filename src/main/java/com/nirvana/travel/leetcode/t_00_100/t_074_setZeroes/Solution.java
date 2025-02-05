package com.nirvana.travel.leetcode.t_00_100.t_074_setZeroes;

/**
 * @author arainliu
 * @date 2024/3/19
 */
public class Solution {
    public void setZeroes(int[][] matrix) {

        boolean[] row = new boolean[matrix.length];
        boolean[] co = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    co[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] || co[j] ) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
