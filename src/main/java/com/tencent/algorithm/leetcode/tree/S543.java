package com.tencent.algorithm.leetcode.tree;

//给定一棵二叉树，你需要计算它的直径长度。
// 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树
// 👍 618 👎 0

import com.tencent.algorithm.leetcode.util.TreeNode;

public class S543{
    public static void main(String[] args) {
        Solution solution = new S543().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int ans;
        int p;
        int q;
        public int diameterOfBinaryTree(TreeNode root) {
           if(root == null){
               return  0;
           }
           ans=1;
           int result =depth(root);
           return ans-1;
        }

        //计算每个节点的最大深度 dfs
        public int depth(TreeNode node) {
            if (node == null) {
                return 0; // 访问到空节点了，返回0
            }
            int L = depth(node.left); // 左儿子为根的子树的深度
            int R = depth(node.right); // 右儿子为根的子树的深度

            ans = Math.max(ans, L+R+1); // 不断的去更新路径长度
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}