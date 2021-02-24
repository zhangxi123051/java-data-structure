package com.tencent.algorithm.leetcode.top100;

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
// 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
// 
//
//示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//5
/// \
//4   8
///   / \
//11  13  4
///  \    / \
//7    2  5   1
//返回:
//
//[
//[5,4,11,2],
//[5,8,4,5]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S113 {
    public static void main(String[] args) {
        S113.Solution solution = new S113().new Solution();



    }

    class Solution {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        Deque<Integer> path = new LinkedList<Integer>();

        public List<List<Integer>> pathSum(TreeNode<Integer>  root, int sum) {
            dfs(root, sum);
            return ret;
        }

        public void dfs(TreeNode<Integer> root, int sum) {
            if (root == null) {
                return;
            }
            path.offerLast(root.val);
            sum -= root.val;
            if (root.left == null && root.right == null && sum == 0) {
                ret.add(new LinkedList<Integer>(path));
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
            //递归回溯
            path.pollLast();
        }
    }


    class Solution2 {
        List<List<Integer>> result= new ArrayList<>();
        //求和
        public int sum(TreeNode<Integer> root, int low, int high) {
            if (root == null) {
                return 0;
            }
            if (root.val >= high || root.val <= low) {
                return sum(root.left, low, high) + sum(root.right, low, high);
            } else {
                return root.val + sum(root.left, low, high) + sum(root.right, low, high);
            }
        }

//        public List<Integer> pathSum(TreeNode root, int targetSum) {
//
//
//            if(root.left == null && root.right == null && targetSum==0){
//
//            }
//
//        }

        public void myPathSum(TreeNode root, int targetSum,List rs) {
            rs.add(root.val);
            if(root.left !=null)

            if(root.left == null && root.right == null && targetSum==0){

            }

        }

    }
}
