package com.nirvana.travel.algorithm.dp.bag;

/**
 * 背包问题：从左往右模型，暴力实现
 * @author arainliu
 * @date 2022/3/21
 */
public class Knapsak {

    public static void main(String[] args) {
        int[] w = new int[]{2, 4, 6, 8, 10,15,10};
        int[] v = new int[]{1,2,3,4,5,6,7};
        System.out.println(getMaxValue(w, v, 40));
        System.out.println(maxValue(w, v, 40));
        System.out.println(processOne(w, v, 40));
    }

    /**
     *
     * @param w 每个货物的重量
     * @param v 每个货物的价值
     * @param bag 背包能承重
     * @return
     */
    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    /**
     * 从背包已经装了多少货物的思路进行暴力递归
     *
     * @param w
     * @param v
     * @param index
     * @param alreadyW [0...index-1]上已经能装的最大重量
     * @param bag
     * @return 从index 往后能装的最大货物价值
     */
    private static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        //认为此事没有可行方案
        if (alreadyW > bag) return -1;
        //index越界，后续产生价值为0
        if (index == w.length) return 0;

        //情况1：不选择当前货物,后面的货物产生的最大价值
        int unSelectV = process(w, v, index + 1, alreadyW, bag);

        //情况2：选择当前货物，后面货物产生的最大价值
        int selectVNext = process(w, v, index + 1, alreadyW + w[index], bag);
        int selectV = -1;
        if (selectVNext != -1) {
            selectV = v[index] + selectVNext;
        }

        return Math.max(unSelectV, selectV);
    }



    //---------------------------------从背包还有多少可装重量进行暴力递归--------------------------------------------------------


    public static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    /**
     *
     * @param w 货物重量数组
     * @param v 货物价值数组
     * @param index 当前递归到的货物index
     * @param rest 从[0...index-1]上装了以后，还剩下的背包可装重量
     * @return 从index...length-1上能装的最大价值
     */
    private static int process(int[] w, int[] v, int index, int rest) {
        //base case 1:背包无剩余空间
        if (rest < 0) return -1;
        //base case 2:index越界
        if (index == w.length) return 0;

        //情况1：不选择当前货物，后续货物产生的最大价值
        int unselectValue = process(w, v, index + 1, rest);
        //情况2：选择当前货物，后续货物产生的最大价值
        int selectValueNext = process(w, v, index + 1, rest - w[index]);

        int selectValue = -1;
        if (selectValueNext != -1) {
            selectValue = v[index] + selectValueNext;
        }

        return Math.max(unselectValue, selectValue);
    }

    //---------------------------------二维dp--------------------------------------------------------

    private static int processTwo(int[] w, int[] v, int bag) {

        System.out.println("-----------------------------------------");
        System.out.println("");
        int[][] dp = new int[w.length+1][bag+1];

        for (int i = bag; i >= w[0]; i--) {
            dp[0][i] = dp[0][i - w[0]] + v[0];
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = 1 ; j <= bag; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
                }
            }
            System.out.println();
        }

        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[0].length; i1++) {
                System.out.print(dp[i][i1] + " ");
            }
            System.out.println();
        }

        return dp[w.length - 1][bag];
    }

    private static int processTwo2(int[] w, int[] v, int bag) {

        System.out.println("--------------------22---------------------");
        System.out.println("");
        int[][] dp = new int[w.length+1][bag+1];

        for (int i = bag; i >= w[0]; i--) {
            dp[0][i] = dp[0][i - w[0]] + v[0];
        }

        for (int i = 1; i <= bag; i++) {
            for (int j = 1; j < w.length; j++) {
                if (i < w[j]) {
                    dp[j][i] = dp[j -1][i];
                } else {
                    dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-w[j]] + v[j]);
                }
            }
        }

//        for (int i = 1; i < w.length; i++) {
//            for (int j = 1 ; j <= bag; j++) {
//                dp[i][j] = dp[i-1][j];
//                if (j >= w[i]) {
//                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
//                }
//            }
//            System.out.println();
//        }

        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[0].length; i1++) {
                System.out.print(dp[i][i1] + " ");
            }
            System.out.println();
        }

        return dp[w.length - 1][bag];
    }

    //--------------------------------- 一维dp --------------------------------------------------------
    private static int processOne(int[] w, int[] v, int bag) {

        System.out.println("-----------------------------------------");
        int[] dp = new int[bag+1];

        for (int i = 0; i < w.length; i++) {
            for (int j = bag ; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j-w[i]]);
            }

            for (int i1 = 0; i1 < dp.length; i1++) {
                System.out.print(dp[i1] + " ");

            }
            System.out.println();
        }

        return dp[bag];
    }

}
