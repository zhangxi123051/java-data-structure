package com.tencent.algorithm.leetcode.tree;



//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[2,1]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 857 👎 0

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public static void main(String[] args) {
        Solution solution = new Solution94().new Solution();
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left=null;
        root.right=new TreeNode<Integer>(2);
        root.right.left=new TreeNode<Integer>(3);
        root.right.right=null;

        System.out.println(solution.inorderTraversal(root));

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
        private List<Integer> list;

        public  Solution() {
            this.list = new ArrayList<Integer>();
        }

        //中序遍历
        public List<Integer> inorderTraversal(TreeNode<Integer> root) {
            if(root ==null){
                return list;
            }

            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);

            return list;
        }

        //前序遍历
        public List<Integer> FirstTraversal(TreeNode<Integer> root) {
            if(root ==null){
                return list;
            }

            list.add(root.val);
            FirstTraversal(root.left);
            FirstTraversal(root.right);

            return list;
        }

        //计算树的高度
    }
//leetcode submit region end(Prohibit modification and deletion)

}