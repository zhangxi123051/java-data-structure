package com.tencent.algorithm.leetcode.top100;

/*
方法一：回溯
思路和算法

这个问题可以看作有 nn 个排列成一行的空格，我们需要从左往右依此填入题目给定的 nn 个数，每个数只能使用一次。那么很直接的可以想到一种穷举的算法，即从左往右每一个位置都依此尝试填入一个数，看能不能填完这 nn 个空格，在程序中我们可以用「回溯法」来模拟这个过程。

我们定义递归函数 backtrack(first, output) 表示从左往右填到第 \textit{first}first 个位置，当前排列为 \textit{output}output。 那么整个递归函数分为两个情况：

如果 \textit{first}==nfirst==n，说明我们已经填完了 nn 个位置（注意下标从 00 开始），找到了一个可行的解，我们将 \textit{output}output 放入答案数组中，递归结束。
如果 \textit{first}<nfirst<n，我们要考虑这第 \textit{first}first 个位置我们要填哪个数。根据题目要求我们肯定不能填已经填过的数，因此很容易想到的一个处理手段是我们定义一个标记数组 \textit{vis}[]vis[] 来标记已经填过的数，那么在填第 \textit{first}first 个数的时候我们遍历题目给定的 nn 个数，如果这个数没有被标记过，我们就尝试填入，并将其标记，继续尝试填下一个位置，即调用函数 backtrack(first + 1, output)。回溯的时候要撤销这一个位置填的数以及标记，并继续尝试其他没被标记过的数。
使用标记数组来处理填过的数是一个很直观的思路，但是可不可以去掉这个标记数组呢？毕竟标记数组也增加了我们算法的空间复杂度。

答案是可以的，我们可以将题目给定的 nn 个数的数组 \textit{nums}nums 划分成左右两个部分，左边的表示已经填过的数，右边表示待填的数，我们在回溯的时候只要动态维护这个数组即可。

具体来说，假设我们已经填到第 \textit{first}first 个位置，那么 \textit{nums}nums 数组中 [0,\textit{first}-1][0,first−1] 是已填过的数的集合，[\textit{first},n-1][first,n−1] 是待填的数的集合。我们肯定是尝试用 [\textit{first},n-1][first,n−1] 里的数去填第 \textit{first}first 个数，假设待填的数的下标为 ii ，那么填完以后我们将第 ii 个数和第 \textit{first}first 个数交换，即能使得在填第 \textit{first}+1first+1个数的时候 \textit{nums}nums 数组的[0,first][0,first] 部分为已填过的数，[\textit{first}+1,n-1][first+1,n−1] 为待填的数，回溯的时候交换回来即能完成撤销操作。

举个简单的例子，假设我们有 [2, 5, 8, 9, 10] 这 5 个数要填入，已经填到第 3 个位置，已经填了 [8,9] 两个数，那么这个数组目前为 [8, 9 | 2, 5, 10] 这样的状态，分隔符区分了左右两个部分。假设这个位置我们要填 10 这个数，为了维护数组，我们将 2 和 10 交换，即能使得数组继续保持分隔符左边的数已经填过，右边的待填 [8, 9, 10 | 2, 5] 。

当然善于思考的读者肯定已经发现这样生成的全排列并不是按字典序存储在答案数组中的，如果题目要求按字典序输出，那么请还是用标记数组或者其他方法

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.*;

public class S46 {
    public  static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.permute(new int[]{1,2,3}));
    }

    static class Solution {


        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>>  result = new ArrayList<>();
            //通过维护一个下标 表示哪些数已经被选择过了
            Set<Integer> set = new HashSet<>();
            dfs(nums,0,new ArrayList(),set,result);
            //System.out.println(result);
            return result;
        }

        public  void dfs(int[] nums,int cur,List data,Set set,List result){
            if(nums.length ==0){
                return;
            }
            if(cur == nums.length){
//                for(int i=0;i<nums.length-1;i++){
//
//                }
                //System.out.println(data);
                result.add(new ArrayList<>(data));
                //System.out.println(result.size());
                return;
            }
            for(int i=0;i<nums.length;i++){
                //这个数已经被选择过
                if(set.contains(i)){
                  continue;
                }

                set.add(i);
                data.add(nums[i]);
                dfs(nums,cur+1,data,set,result);
                set.remove(i);
                data.remove(cur);
            }
        }
    }


    static class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
            }
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }
    }



}
