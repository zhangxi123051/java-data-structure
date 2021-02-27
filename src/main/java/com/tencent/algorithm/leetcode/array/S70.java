package com.tencent.algorithm.leetcode.array;

public class S70 {

    class Solution {
        public int climbStairs(int n) {
            if(n == 0) return 0;
            if(n==1) return 1;
            if(n==2) return 2;

            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    class Solution2 {
        public int climbStairs(int n) {
            if(n<0){
                return 0;
            }

            if(n == 0 || n==1 || n==2){
                return n;
            }

            int[] dp = new int[n+1];
            dp[0]=0;
            dp[1]=1;
            dp[2]=2;
            for(int i=3;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
    }
}
