package com.tencent.plan.leetcode;


import java.util.ArrayList;
import java.util.List;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯算法
// 👍 991 👎 0
public class Solution78 {

    public static void main(String[] args) {
        Solution solution = new Solution78().new Solution();
        int[] nums = new int[]{1,3,5,7};
        System.out.println("size="+solution.subsets(nums).size());
        System.out.println(solution.subsets(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result  = new ArrayList<>();
            result.add(new ArrayList<Integer>());
            for(int i: nums){
                List<List<Integer>> subsets = new ArrayList<>();
                for(List<Integer> item:result){
                    List<Integer> temp = new ArrayList<>(item);
                    temp.add(i);
                    subsets.add(temp);
                }
                //将subnets中的list加入到result中
                for(List<Integer> item:subsets){
                    result.add(item);
                }
            }

            return result;

        }
    }
}
