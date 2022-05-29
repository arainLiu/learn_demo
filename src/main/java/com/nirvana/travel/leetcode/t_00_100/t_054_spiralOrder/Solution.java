package com.nirvana.travel.leetcode.t_00_100.t_054_spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arainliu
 * @date 2021/12/29
 */
public class Solution {

  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> resList = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return resList;
    }

    int rows = matrix.length;
    int columns = matrix[0].length;
    boolean[][] visited = new boolean[rows][columns];
    int total = rows * columns;

    int row=0, column=0;

    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int index = 0;

    while (resList.size() < total) {
      resList.add(matrix[row][column]);
      visited[row][column] = true;
      //找下一个行、列的位置
      int nextR = row + dr[index];
      int nextC = column + dc[index];
      if (nextR >=0 && nextR < rows && nextC >=0 && nextC < columns && !visited[nextR][nextC]) {
        row = nextR;
        column = nextC;
      } else {
        index = (index + 1) % 4;
        nextR = row + dr[index];
        nextC = column + dc[index];
        row = nextR;
        column = nextC;
      }

    }

    return resList;
  }

}
