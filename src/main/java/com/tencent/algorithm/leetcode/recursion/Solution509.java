package com.tencent.algorithm.leetcode.recursion;

public class Solution509 {


    public int func(int n){
        if(n==0 || n==1){
            return n;
        }
        return func(n-1)+func(n-2);
    }
    public static void main(String args[]){
       System.out.println(new Solution509().func(3));
    }

}
