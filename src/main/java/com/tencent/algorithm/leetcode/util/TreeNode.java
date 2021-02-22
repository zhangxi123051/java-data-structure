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
    }
