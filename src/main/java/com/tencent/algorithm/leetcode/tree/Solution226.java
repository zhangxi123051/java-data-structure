package com.tencent.algorithm.leetcode.tree;


/*
翻转一棵二叉树
 */


//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树
// 👍 762 👎 0

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.List;

public class Solution226{
    public static void main(String[] args) {
        Solution solution = new Solution226().new Solution();

        TreeNode root = TreeNode.createTree();

        System.out.println("node count:"+TreeNode.getNodeCount(root));

        List<List<Integer>> result = TreeNode.levelTraversal(root);
        System.out.println("before:"+result);

        root = solution.invertTree(root);

        result = TreeNode.levelTraversal(root);
        System.out.println("after:"+result);

    }
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            TreeNode tmp =root;

            if(root == null){
                return null;
            }

            TreeNode temp = root.left;
            root.left=root.right;
            root.right=temp;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}