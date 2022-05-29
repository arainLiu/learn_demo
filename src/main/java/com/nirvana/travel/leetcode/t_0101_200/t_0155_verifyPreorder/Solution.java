package com.nirvana.travel.leetcode.t_0101_200.t_0155_verifyPreorder;

import java.util.Stack;

/**
 * @author arainliu
 * @date 2022/3/2
 */
public class Solution {

    /**
     * 思路：
     *   单调栈思路解决
     * 如果出现非递减的值，意味着到了某个节点的右子树；
     * 利用栈来寻找该节点，最后一个比当前元素小的从栈弹出的元素即为该节点的父亲节点，而且当前元素父节点即为新的下限值；
     * 后续的元素一定是比当前的下限值要大的，否则return false；
     *
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            //如果当前元素<最小值，即父节点的值 > 右子树的值
            if (preorder[i] < min) return false;
            //从栈中弹出比当前元素小的值，最后一个弹出的值为当前元素的父节点，设置为下限值
            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                min = stack.pop();
            }
            stack.push(preorder[i]);
        }

        return true;
    }
}
