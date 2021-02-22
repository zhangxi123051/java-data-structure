package com.tencent.algorithm.leetcode.dp;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//
// 示例 2：
//
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
//输入：m = 7, n = 3
//输出：28
//
//
// 示例 4：
//
//
//输入：m = 3, n = 3
//输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数组 动态规划
// 👍 890 👎 0

//[r][c]=[r-1][c]+[r][c-1]
//[0][0]=1

//fb(n)=fb(n-1)+f(n-2)
//fb(1)=1
//fb(0)=0

import com.tencent.springaop.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;

public class Solution62{
    public static void main(String[] args) {
        Solution solution = new Solution62().new Solution();

        System.out.println(solution.flb(10));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            return 0;
        }

        public int flb(int n) {
            int[] dp = new int[n+1];
            dp[0]=0;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }

            for(int num:dp){
                System.out.print(num+" ");
            }
            //Arrays.asList(dp);

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
