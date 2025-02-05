package com.nirvana.travel.leetcode.t_00_100.t_042_trap;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2024/2/22
 */
public class Solution {

    /**
     * 首先找到数组中最大值的索引位置maxIndex
     * 构建dp数组，表示i位置上接雨水的条件下的最大高度，
     *   从[0...maxIndex]上,定义初始条件dp[0]=height[0],dp[i] = max(dp[i-1], height[i])
     *   从[len-1...maxIndex]上，定义初始条件 dp[len-1]=height[len-1],从后往前遍历，dp[i] = max(dp[i+1], height[i])
     * 此时，得到整个数组上装水条件下的高度数组，
     * @param height
     * @return
     */
    public int trapDp1(int[] height) {
        if (height == null || height.length <=2) {
            return 0;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        //以maxIndex未边界，从左往右构建最大值数组
        int len = height.length;
        int[] maxArr = new int[len];
        maxArr[0] = height[0];
        maxArr[len-1] = height[len-1];
        for (int i = 1; i <= maxIndex; i++) {
            maxArr[i] = Math.max(maxArr[i-1], height[i]);
        }

        for (int i = len - 2; i > maxIndex; i--) {
            maxArr[i] = Math.max(maxArr[i+1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += (maxArr[i] - height[i]);
        }

        return res;
    }

    public int trapDp2(int[] height) {
        if (height == null || height.length <= 1) return 0;

        int len = height.length;
        //从左往右遍历计算当前位置作为左侧可接水的最大高度
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        //从右往左遍历计算当前位置作为右侧可接水的最大高度
        int[] rightMax = new int[len];
        rightMax[len-1] = height[len-1];
        for (int i = len - 2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,0,1};
        System.out.println(trapStack(arr));
    }

    /**
     * 维护一个单调递减栈
     * @param height
     * @return
     */
    public static int trapStack(int[] height) {
        if (height == null || height.length <= 2) return 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        //从i依次入栈
        for (int i = 0; i < height.length; i++) {
            /*
             * 当出现当前i位置的元素出现递增的时候，说明出现能接雨水的位置，需要进行处理
             * 每次while循环能够把i位置和之前位置组合能接雨水的所有数量计算出来，
             *   关键在 height[i] > height[stack.peek()]时,每次都会把栈顶弹出，继续计算之前的高度下和i位置组合能行成的凹处
             *    直到把栈中<height[i]的元素全部弹出，此时当前位置i 和之前位置组合不能继续接雨水
             */
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();//取出当前栈顶位置，当前位置的高度往上才有可能接雨水
                if (stack.isEmpty()) break;//循环结束条件，每次都会把i之前的元素全部弹出栈
                int left = stack.peek();//查看当前栈顶的值作为存雨水的左边界
                int width = i - left - 1;//计算可以存雨水的宽度
                int hi = Math.min(height[i], height[left]) - height[top];//接雨水高度=左右边界最小值-当前位置的高度
                res += width * hi;//存水=长*宽
            }
            //把当前位置入栈，作为
            stack.push(i);
        }

        return res;
    }

    public int trapPoint(int[] height) {

        if (height == null || height.length <= 2) return 0;

        int left =0;
        int right = height.length - 1;
        int leftmax = 0;//到当前节点为止从左往右的最大高度
        int rightmax=0;//到当前节点为止的从右往左最大高度

        int res =0;
        while (left < right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            //这里只是一个假设，height[right] > height[left],才有可能在left处 形成凹处，忽略掉[left+1...right-1]上元素去看
            //此时具体是否形成接雨水的点，还要看leftmax和height[left]的大小
            if (height[left] < height[right]) {
                res += leftmax - height[left]; //此处可能leftmax == height[left],此处实际能接雨水 0
                left ++;
            } else {
                res += rightmax - height[right];//rightmax == height[right],此处实际能接雨水 0
                right --;
            }
        }
        return res;
    }
}
