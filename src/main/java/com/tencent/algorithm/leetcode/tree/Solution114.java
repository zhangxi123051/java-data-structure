package com.tencent.algorithm.leetcode.tree;




//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
// Related Topics 树 深度优先搜索
// 👍 728 👎 0

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution114{
    public static void main(String[] args) {
        Solution solution = new Solution114().new Solution();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);

        root.right=new TreeNode(6);
        root.right.right=new TreeNode(5);

        System.out.println(TreeNode.levelTraversal(root));

        TreeNode tmp =root;
        solution.flatten3(tmp);


        List<Integer> result = new ArrayList<>();

        TreeNode.preorderTraversal(root,result);

        //solution.flatten(root,result);

        System.out.println(result);

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
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.left);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            flatten(right);
            root.right = right;
        }

        public void flatten3(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode next = curr.left;
                    TreeNode predecessor = next;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    predecessor.right = curr.right;
                    curr.left = null;
                    curr.right = next;
                }
                curr = curr.right;
            }
        }


        public void flatten2(TreeNode root){
            List<Integer> result = new ArrayList<>();
            flatten(root, result);
            for(int i:result){

            }
        }
        public void flatten(TreeNode<Integer> root, List<Integer> result) {
            if(root == null){
                return;
            }
            result.add(root.val);
            flatten(root.left,result);
            flatten(root.right,result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}