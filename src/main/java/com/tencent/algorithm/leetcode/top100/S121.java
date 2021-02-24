package com.tencent.algorithm.leetcode.top100;
//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2：
//
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
//
// Related Topics 数组 动态规划
// 👍 1453 👎 0

public class S121{
    public static void main(String[] args) {
        Solution solution = new S121().new Solution();
//        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
//
//
//        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));


        System.out.println(solution.maxProfit3(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit3(new int[]{7,6,4,3,1}));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int max=0;
            for(int i=0;i<=n-2;i++){
                for(int j=i+1;j<=n-1;j++){
                    max=Math.max(prices[j]-prices[i],max);
                }
            }
          return max;
        }

        /*

         */
        public int maxProfit2(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }

        /*
        解题思路
        到最后交易结束时，一共会有3种状态：

        dp0：一直不买
        dp1：只买了一次
        dp2：买了一次，卖了一次
        初始化3种状态：

        dp0 = 0
        dp1 = - prices[0]
        dp2 = float("-inf")
        因为第一天不可能会有dp2状态，因此将dp2置为负无穷
        (Java中置为int的下边界)
        对3种状态进行状态转移：

        dp0 = 0
        一直为0
        dp1 = max(dp1, dp0 - prices[i])
        前一天也是dp1状态，或者前一天是dp0状态，今天买入一笔变成dp1状态
        dp2 = max(dp2, dp1 + prices[i])
        前一天也是dp2状态，或者前一天是dp1状态，今天卖出一笔变成dp2状态
        最后一定是手里没有股票赚的钱最多，因此返回的是dp0，dp2的最大值

         */
        public int maxProfit3(int[] prices) {
            int dp0 = 0;                    // 一直不买
            int dp1 = - prices[0];          // 只买了一次
            int dp2 = Integer.MIN_VALUE;    // 买了一次，卖了一次

            for(int i = 1; i < prices.length; i++){
                dp1 = Math.max(dp1, dp0 - prices[i]);
                dp2 = Math.max(dp2, dp1 + prices[i]);
            }
            return Math.max(dp0, dp2);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
