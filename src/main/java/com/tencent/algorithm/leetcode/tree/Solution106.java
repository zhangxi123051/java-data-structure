package com.tencent.algorithm.leetcode.tree;



//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 447 👎 0

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution106{
    public static void main(String[] args) {
        Solution solution = new Solution106().new Solution();



        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3};



        TreeNode root = solution.buildTree(inorder,postorder);

        List<Integer> postResult = new ArrayList<>();
        List<Integer> inResult = new ArrayList<>();


        TreeNode.inorderTraversal(root,inResult);
        TreeNode.postorderTraversal(root,postResult);

        System.out.println(inResult);
        System.out.println(postResult);


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
        HashMap<Integer, Integer> indexMap = new HashMap<>();

//        preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
//        inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]

        //递归的方式 根据一棵树的中序遍历与前序遍历构造二叉树

        public TreeNode reCurBuildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return reCurMyBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }

        public TreeNode reCurMyBuildTree(int[] preorder, int[] inorder,int preLow,
                                    int preHigh,int inLow,int inHigh){
            if(preLow > preHigh){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preLow]);

            int  rootIndex = indexMap.get(root.val);

            int leftLength=rootIndex-inLow;
            int rightLenght=inHigh-rootIndex;


            root.left=reCurMyBuildTree(preorder,inorder,preLow+1,preLow+leftLength,
                    inLow,rootIndex-1);
            root.right=reCurMyBuildTree(preorder,inorder,preLow+leftLength+1,preHigh,
                    rootIndex+1,inHigh);

            return root;
        }


        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }

           return myBuildTree(inorder,postorder,0,n-1,0,n-1);
        }



        //递归的方式 根据一棵树的中序遍历与后序遍历构造二叉树
        // 中序遍历 inorder = [9,3,15,20,7]
        //后序遍历 postorder = [9,15,7,20,3]
        //
        // 返回如下的二叉树：
        //
        //     3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        public TreeNode myBuildTree(int[] inorder, int[] postorder,int inLow,int inHigh,
                                    int postLow,int postHigh) {

            if(inLow > inHigh){
                return null;
            }
            TreeNode root = new TreeNode(postorder[postHigh]);
            int inIndex= indexMap.get(root.val);
            int leftCount=inIndex-inLow;
            int rightCount=inHigh-inIndex;

            root.left=myBuildTree(inorder,postorder,inLow,inIndex-1,
                    postLow,postLow+leftCount-1);

            root.right=myBuildTree(inorder,postorder,inIndex+1,inHigh,
                    postLow+leftCount,postHigh-1);

            return root;
        }

        //迭代法

    }
//leetcode submit region end(Prohibit modification and deletion)

}