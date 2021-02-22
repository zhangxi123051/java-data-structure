package com.tencent.algorithm.leetcode.tree;



//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 773 👎 0

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.*;

public class Solution102{

    //https://blog.csdn.net/qq_38765867/article/details/88370997
    public static void main(String[] args) {
        Solution solution = new Solution102().new Solution();

        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left=new TreeNode<Integer>(2);;
        root.right=new TreeNode<Integer>(7);
        root.right.left=new TreeNode<Integer>(6);
        root.right.right=null;




        Stack<List<Integer>> result = solution.levelBfsOrder2(root);
        System.out.println(result);

        while(!result.isEmpty()){
            System.out.println(result.pop());
        }


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
        public List<List<Integer>> levelBfsOrder(TreeNode<Integer> root) {
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


        /*
        从下往上  层次化输出
         */
        public Stack<List<Integer>> levelBfsOrder2(TreeNode<Integer> root) {
            //定义结果集

            Stack<List<Integer>> result = new Stack<>();
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

                result.push(list);
            }
            return result;

        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            //定义结果集
            List<List<Integer>> result = new ArrayList<>();
            //递归等级
            int level = 0;

            return dfs(root, level, new ArrayList<>());
        }

        private List<List<Integer>> dfs(TreeNode<Integer> root,int level,List<List<Integer>> result) {
            //递归终止条件
            if (root == null)
                return new ArrayList<>();
            //定义一个每一层的list
            List<Integer> currentList;
            //如果当前层没有结果，即当前的result的大小 等于level，因为每添加一个list，result的大小就会加1。

            if (result.size() == level) {
                currentList = new ArrayList<>();
                currentList.add(root.val);
                result.add(currentList);
            } else {
                currentList = result.get(level);//获得已存在的level
                currentList.add(root.val);
                result.set(level, currentList);//将新输入的list放回原来所在的result的位置
            }

            dfs(root.left, level + 1, result);
            dfs(root.right, level + 1, result);

            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}