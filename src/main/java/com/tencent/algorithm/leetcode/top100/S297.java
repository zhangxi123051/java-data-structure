package com.tencent.algorithm.leetcode.top100;

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.lang.management.BufferPoolMXBean;

public class S297 {


    public static void main(String[] args) {
        S297.Solution solution = new S297().new Solution();
        TreeNode root= TreeNode.createTree();
        System.out.println(solution.serialize(root));

        solution.deserialize("124##3##76###");
    }

    public class Solution {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            Myserialize(root,sb);
            return sb.toString();
        }

        private void Myserialize(TreeNode root, StringBuffer sb){
           if(root ==null){
               sb.append("#");
               return;
           }

           sb.append(root.val);
           Myserialize(root.left,sb);
           Myserialize(root.right,sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

}
