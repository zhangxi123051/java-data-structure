package com.tencent.plan.leetcode;


import java.util.Arrays;
import java.util.logging.Logger;

/*
  leetcode56 合并区间
 */
public class Solution56 {

    public int[][] merge(int[][] intervals){
        return intervals;
    }

    public static void main(String[] args){
        int[][] intervals = new int[][]{{1,3},{4,5}};
        int[][] result = new Solution56().merge(intervals);
        for(int[] data: result){
            System.out.println("{"+data[0]+","+data[1]+"}");
        }
    }
}
