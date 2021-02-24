package com.tencent.algorithm.leetcode.util;

import java.sql.PreparedStatement;
import java.util.*;

//public class TreeNode<T> {
//    public  TreeNode left = null;
//    public  TreeNode right=null;
//    public  T value;
//
//    public TreeNode(T value){
//        this.value=value;
//    }
//}


public class TreeNode<E> {
        public E val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(E val) { this.val = val; }
        public TreeNode(E val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }

        public static TreeNode<Integer> createTree(int[] nums){
            return null;
        }

       public static TreeNode<Integer> createTree(){
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left=new TreeNode<Integer>(2);;
        root.right=new TreeNode<Integer>(7);

        root.left.left=new TreeNode<Integer>(4);;
        root.left.right=new TreeNode<Integer>(3);
        root.right.left=new TreeNode<Integer>(6);
        root.right.right=null;
        return  root;
        }

        public static int  getNodeCount(TreeNode root){
            if(root == null){
                return 0;
            }
           return 1+getNodeCount(root.left)+getNodeCount(root.right);
        }


        //层次遍历
        public static List<List<Integer>> levelTraversal(TreeNode root) {
            //定义结果集
            List<List<Integer>> result = new ArrayList<>();
            if(root == null)
                return result;//不是都返回null的，这里返回result
            Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列
            queue.add(root);//把根节点添加入队列
            while(!queue.isEmpty()){//队列不为空即一直循环
                List<Integer> list = new ArrayList<>();//定义一个每一层的list
                int levelSize = queue.size();//队列中目前所存在的数即为当前层所有的数

                for(int i = 0; i < levelSize; i++){
                    TreeNode<Integer> currentNode = queue.poll();//获得并移除第一个节点在遍历的里面，这样才能将当前层的数全部从队列中移除
                    list.add(currentNode.val);//当前层的节点加入
                    if(currentNode.left != null)
                        queue.add(currentNode.left);//先把左节点加入队列
                    if(currentNode.right != null)
                        queue.add(currentNode.right);//再加入右节点
                }
                result.add(list);
            }
            return result;
        }

        /* 主函数 */
        public static TreeNode constructMaximumBinaryTree(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        /* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
        public static  TreeNode build(int[] nums, int lo, int hi) {
            // base case
            if (lo > hi) {
                return null;
            }

            // 找到数组中的最大值和对应的索引
            int index = -1, maxVal = Integer.MIN_VALUE;
            for (int i = lo; i <= hi; i++) {
                if (maxVal < nums[i]) {
                    index = i;
                    maxVal = nums[i];
                }
            }

            TreeNode root = new TreeNode(maxVal);
            // 递归调用构造左右子树
            root.left = build(nums, lo, index - 1);
            root.right = build(nums, index + 1, hi);

            return root;
        }



        public static List preorderTraversal(TreeNode<Integer> root){
            List<Integer> result= new ArrayList<>();
            preorderTraversal(root,result);
            return result;
        }
        //前序遍历
        public static void preorderTraversal(TreeNode<Integer> root,List<Integer> result) {
            if(root ==null){
                return ;
            }

            result.add(root.val);
            preorderTraversal(root.left,result);
            preorderTraversal(root.right,result);

            return;
        }



        public static List inorderTraversal(TreeNode<Integer> root){
            List<Integer> result= new ArrayList<>();
            inorderTraversal(root,result);
            return result;
        }

        //中序遍历
        public static void inorderTraversal(TreeNode<Integer> root,List<Integer> result) {
            if(root ==null){
                return ;
            }

            inorderTraversal(root.left,result);
            result.add(root.val);
            inorderTraversal(root.right,result);

            return;
        }

        //后序遍历
        public static void postorderTraversal(TreeNode<Integer> root,List<Integer> result) {
            if(root ==null){
                return ;
            }

            postorderTraversal(root.left,result);
            postorderTraversal(root.right,result);
            result.add(root.val);

            return;
        }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = inorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        HashMap<Integer, Integer>  indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(inorder,postorder,0,n-1,0,n-1,indexMap);
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
    private static TreeNode myBuildTree(int[] inorder, int[] postorder,int inLow,int inHigh,
                                int postLow,int postHigh,HashMap<Integer, Integer> indexMap) {

        if(inLow > inHigh){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postHigh]);
        int inIndex= indexMap.get(root.val);
        int leftCount=inIndex-inLow;
        int rightCount=inHigh-inIndex;

        root.left=myBuildTree(inorder,postorder,inLow,inIndex-1,
                postLow,postLow+leftCount-1,indexMap);

        root.right=myBuildTree(inorder,postorder,inIndex+1,inHigh,
                postLow+leftCount,postHigh-1,indexMap);

        return root;
    }


    }
