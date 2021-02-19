package com.tencent.algorithm.leetcode.twoPoint;



//第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
//
// 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
//
// 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
//
//
//
// 示例 1：
//
// 输入：people = [1,2], limit = 3
//输出：1
//解释：1 艘船载 (1, 2)
//
//
// 示例 2：
//
// 输入：people = [3,2,2,1], limit = 3
//输出：3
//解释：3 艘船分别载 (1, 2), (2) 和 (3)
//
//
// 示例 3：
//
// 输入：people = [3,5,3,4], limit = 5
//输出：4
//解释：4 艘船分别载 (3), (3), (4), (5)
//
// 提示：
//
//
// 1 <= people.length <= 50000
// 1 <= people[i] <= limit <= 30000
//
// Related Topics 贪心算法 双指针
// 👍 81 👎 0

import java.util.*;

public class Solution881{
    public static void main(String[] args) {
        Solution solution = new Solution881().new Solution();
        int[] nums =new int[]{1,2,3,2,4};
        int limit =4;

        System.out.println(solution.numRescueBoats(nums,limit));

    }
    class Solution {
        public int numRescueBoats(int[] nums, int limit) {
            Arrays.sort(nums);
            int result =0;
            int i=0,j=nums.length-1;
            while(i<=j){
                if(nums[j]>=limit || (nums[i]+nums[j] > limit)){
                    result=result+1;
                    j=j-1;
                }else {
                    result = result + 1;
                    i = i + 1;
                    j=j-1;
                }

            }


            return result;
        }
    }
}