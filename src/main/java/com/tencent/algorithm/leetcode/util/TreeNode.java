package com.tencent.algorithm.leetcode.util;

import java.sql.PreparedStatement;
import java.util.TreeMap;

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
}
