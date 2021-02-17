package com.tencent.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1127 👎 0

public class Solution46{
    public static void main(String[] args) {
        Solution solution = new Solution46().new Solution();

        Solution2 solution2 = new Solution46().new Solution2();

        Solution3 solution3 = new Solution46().new Solution3();

        List<List<Integer>> res = solution3.permute(new int[]{4,6,5});
        System.out.println("size="+res.size());
        for(List<Integer> item:res){
            System.out.println(item);
        }




    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            helper(nums, 0);
            return res;
        }

        public void helper(int[] nums, int i){
            // 找到转置完成后的解，将其存入列表中
            if(i == nums.length - 1){
                List<Integer> list = new ArrayList<Integer>();
                for(int j = 0; j < nums.length; j++){
                    list.add(nums[j]);
                }
                res.add(list);
            }
            // 将当前位置的数跟后面的数交换，并搜索解
            for(int j = i; j < nums.length; j++){
                swap(nums, i , j);
                helper(nums, i + 1);
                swap(nums, i, j);
            }
        }

        private void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


    /*
     递归回溯
     */
    public  class Solution2{
        List<List<Integer>> res;// 存放结果的对象
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<List<Integer>>();
            DFS(nums,initializeBooleanArray(nums.length),new ArrayList<Integer>());// 收集全排列的所有排列结果
            return res;
        }

        // 循环选择固定哪一个数字（选择哪一个作为起始数字）
        public void DFS(int[] nums,boolean[] visited,List<Integer> tmp){
            // 如果tmp中存放的数字已经将所有nums中的数字都放入了，那么就将其输入到res中
            if(tmp.size()==nums.length){
                res.add(new ArrayList<Integer>(tmp));
                System.out.println(tmp);
                return;
            } else{
                // 否则，开始循环遍历，按照0,1,2..的顺序依次选择起点，然后遍历
                for(int i=0;i<nums.length;i++){
                    if(visited[i])// 若该点已经被访问过了，则跳过访问下一个点
                        continue;
                    else{// 若没被访问过，那么先标记为访问了，然后将其加入tmp中，等待tmp长度足够时写入res中
                        visited[i] = true;
                        tmp.add(nums[i]);
                        DFS(nums,visited,tmp);// 递归调用，通过形参维护的 逻辑栈的变量有：tmp，visited
                        tmp.remove(tmp.size()-1);// 递归结束，还原该点的状态，使得获取下一个组合的遍历还能再经过此点
                        visited[i]=false;// 访问标记还原
                    }
                }
            }
        }

        // 获取一个与num相等大小的boolean数组
        public boolean[] initializeBooleanArray(int num){
            boolean[] res = new boolean[num];
            for(int i=0;i<num;i++){
                res[i] = false;
            }
            return res;
        }
    }


    /*
     多层循环   --> 转换为递归回溯
     */
    public  class Solution3{
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            for(int i=0;i<nums.length;i++){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[i]);
                for(int j=0;j<nums.length;j++){
                    if(j!=i){
                        tmp.add(nums[j]);
                        for(int k=0;k<nums.length;k++){
                            if(k !=i && k !=j){
                                tmp.add(nums[k]);
                                res.add(new ArrayList<>(tmp));
                                tmp.remove((Object)nums[k]);
                            }

                        }

                        tmp.remove((Object)nums[j]);
                    }
                }
                tmp.remove((Object)nums[i]);
            }
            return res;
        }
    }



    /*
     找出所有的子集,然后输出长度为3的子集
     */
    public  class Solution4{
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            for(int i=0;i<nums.length;i++){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[i]);
                for(int j=0;j<nums.length;j++){
                    if(j!=i){
                        tmp.add(nums[j]);
                        for(int k=0;k<nums.length;k++){
                            if(k !=i && k !=j){
                                tmp.add(nums[k]);
                                res.add(new ArrayList<>(tmp));
                                tmp.remove((Object)nums[k]);
                            }

                        }

                        tmp.remove((Object)nums[j]);
                    }
                }
                tmp.remove((Object)nums[i]);
            }
            return res;
        }
    }
   //leetcode submit region end(Prohibit modification and deletion)

}
