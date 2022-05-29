package com.nirvana.travel.algorithm.dp.convertToLetter;

/**
 * 规定1和A对应、2和B对应、3和C对应...
 * 那么一个数字字符串比如"111”就可以转化为:
 * "AAA"、"KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 *
 * @author arainliu
 * @date 2022/3/21
 */
public class ConvertToLetterString {

    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    /**
     * 返回[index, length-1]上有多少种转化结果
     * @param strArr 数组，固定
     * @param index 当前访问的位置
     * @return 返回在[0...index-1]已经确定的情况下，从[index, length-1]上有多少种转化结果
     */
    private static int process(char[] strArr, int index) {
        //base case:index越界，表示当前已经转化完
        if (index == strArr.length) return 1;
        //base case:当数组值为'0'，i没有到终止位置，比如 10可以对应J,或者A0，当第一个是A，第二次是0是，就没有办法转化了，整条链路无效
        if (strArr[index] == '0') return 0;

        //分情况讨论
        if (strArr[index] == '1') {
            //index作为单独的部分，后续还能提供多少种方案
            int res = process(strArr, index +1);
            if (index + 1 < strArr.length) {
                //index和index+1位置作为一个部分，后续能提供的方案数量
                res += process(strArr, index + 2);
            }
            return res;
        }

        if (strArr[index] == '2') {
            //index作为单独的部分，后续能提供的方案数量
            int res = process(strArr, index + 1);
            if (index + 1 < strArr.length && strArr[index + 1] >= '0' && strArr[index + 1] <= '6') {
                res += process(strArr, index + 2);
            }
            return res;
        }
        //当strArr[index] 是'3'~'9'，只能单独作为独立的部分，后续能提供的方案数量
        return process(strArr, index + 1);
    }

}
