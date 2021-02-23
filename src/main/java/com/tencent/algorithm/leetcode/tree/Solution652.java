package com.tencent.algorithm.leetcode.tree;

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树
// 👍 234 👎 0

public class Solution652{
    public static void main(String[] args) {
        Solution2 solution = new Solution652().new Solution2();

        //根据前序和中序序列创建树
//        int[] inorder = new int[]{4,2,1,4,3,3,4};
//        int[] postorder = new int[]{};

//                根据一棵树的中序遍历与后序遍历构造二叉树

//        TreeNode.buildTree()

        // 中序遍历 inorder = [9,3,15,20,7]
        //后序遍历 postorder = [9,15,7,20,3]


        // 1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4


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
        int t;
        Map<String, Integer> trees;
        Map<Integer, Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            t = 1;
            trees = new HashMap();
            count = new HashMap();
            ans = new ArrayList();
            lookup(root);
            return ans;
        }

        public int lookup(TreeNode node) {
            if (node == null) return 0;
            String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
            int uid = trees.computeIfAbsent(serial, x-> t++);
            count.put(uid, count.getOrDefault(uid, 0) + 1);
            if (count.get(uid) == 2)
                ans.add(node);
            return uid;
        }
    }

    class Solution2 {
        Map<String, Integer> count;
        List<TreeNode> ans;
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count = new HashMap();
            ans = new ArrayList();
            collect(root);
            return ans;
        }

        public String collect(TreeNode node) {
            if (node == null) return "#";
            String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
            count.put(serial, count.getOrDefault(serial, 0) + 1);

            ans.add(node);
//            if (count.get(serial) == 2)
//                ans.add(node);
            return serial;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}