package com.tencent.algorithm.leetcode.tree;

import apple.laf.JRSUIUtils;
import com.tencent.algorithm.leetcode.util.TreeNode;
import com.tencent.springaop.util.StringUtils;

/*
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.

 */
import java.util.*;

public class S129 {
    public static void main(String[] args) {
        S129.Solution solution = new S129().new Solution();
        //TreeNode root =TreeNode.createTree();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        //root.left.left=new TreeNode(4);
        root.right=new TreeNode(3);
        //root.right.left=new TreeNode(5);
        System.out.println(TreeNode.preorderTraversal(root));

        System.out.println(solution.binaryTreePaths(root));

        System.out.println(solution.sumNumbers(root));


    }

    class Solution {


        public int sumNumbers(TreeNode root) {
            List<String> result = new ArrayList<>();
            dfs(root,  new LinkedList<>(),result);
            int sum=0;
            for(String str:result){
                sum=sum+Integer.parseInt(str);
            }
            return sum;
        }

        public List<String> binaryTreePaths(TreeNode root) {

            List<String> result = new ArrayList<>();
            dfs(root,  new LinkedList<>(),result);
            return result;
        }

        private void dfs(TreeNode root, String path, List<String> res) {
            //如果为空，直接返回
            if (root == null)
                return;
            //如果是叶子节点，说明找到了一条路径，把它加入到res中
            if (root.left == null && root.right == null) {
                res.add(path + root.val);
                return;
            }
            //如果不是叶子节点，在分别遍历他的左右子节点
            dfs(root.left, path + root.val + "->", res);
            dfs(root.right, path + root.val + "->", res);
        }



        public void dfs(TreeNode root, LinkedList res,List result){

            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                res.addLast(root.val+"");
                ;
                //res.append(root.val);
                result.add(String.join("",res));
                return;
            }


            res.addLast(root.val+"");

            if(root.left !=null) {
                dfs(root.left,res,result);
                res.removeLast();
            }

            if(root.right !=null) {
                dfs(root.right,res,result);
                res.removeLast();
            }
        }

    }

}
