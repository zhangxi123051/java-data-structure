package com.tencent.algorithm.leetcode.top100;


/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

你可以认为每种硬币的数量是无限的。

 

示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
示例 4：

输入：coins = [1], amount = 1
输出：1
示例 5：

输入：coins = [1], amount = 2
输出：2
 

提示：

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S322 {


    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 自底向上的动态规划
            if(coins.length == 0){
                return -1;
            }

            // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
            int[] memo = new int[amount+1];
            memo[0] = 0;
            for(int i = 1; i <= amount;i++){
                int min = Integer.MAX_VALUE;
                for(int j = 0;j < coins.length;j++){
                    if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
                        min = memo[i-coins[j]] + 1;
                    }
                }
                // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
                memo[i] = min;
            }

            return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
        }
    }


    class Solution2 {
        public int coinChange(int[] coins, int amount) {

            return 0;
        }
    }
}
