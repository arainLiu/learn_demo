package com.nirvana.travel.me.base.threadpool;

/**
 * @author arainliu
 * @date 2021/10/26
 */
public class CoreCodeTest {

  public static void main(String[] args) {

    int COUNT_BITS = Integer.SIZE - 3;
    int RUNNING    = -1 << COUNT_BITS;
    int SHUTDOWN   =  0 << COUNT_BITS;
    int STOP       =  1 << COUNT_BITS;
    int TIDYING    =  2 << COUNT_BITS;
    int TERMINATED =  3 << COUNT_BITS;

    System.out.println(Integer.toBinaryString(RUNNING));
    System.out.println(Integer.toBinaryString(SHUTDOWN));
    System.out.println(Integer.toBinaryString(STOP));
    System.out.println(Integer.toBinaryString(TIDYING));
    System.out.println(Integer.toBinaryString(TERMINATED));

  }

}
