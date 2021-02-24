package com.tencent.algorithm.leetcode.tree;

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class S297 {


    public static void main(String[] args) {
        Solution solution = new S297().new Solution();
        TreeNode root= TreeNode.createTree();


        System.out.println(TreeNode.levelTraversal(root));
        System.out.println(TreeNode.preorderTraversal(root));
        System.out.println(TreeNode.inorderTraversal(root));
        System.out.println(solution.serialize(root));

        //solution.deserialize("124##3##76###");

        TreeNode root2 = solution.deserialize("1,2,4,#,#,3,#,#,-7,6,#,#,#");

        System.out.println(TreeNode.levelTraversal(root2));
        System.out.println(TreeNode.preorderTraversal(root2));
        System.out.println(TreeNode.inorderTraversal(root2));

        System.out.println("maxPathSum="+solution.maxPathSum(root2));
    }

    public class Solution {

        /*
          最大路径和
         */
        public int maxPathSum(TreeNode<Integer> root){
            if(root == null){
                return 0;
            }
            if(root.val <0){
                return Math.max(maxPathSum(root.left),maxPathSum(root.right));
            }else{
                return root.val+Math.max(maxPathSum(root.left),maxPathSum(root.right));
            }

        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            Myserialize(root,sb);
            return sb.toString();
        }

        private void Myserialize(TreeNode root, StringBuffer sb){
           if(root ==null){
               sb.append("#").append(",");
               return;
           }

           sb.append(root.val).append(",");
           Myserialize(root.left,sb);
           Myserialize(root.right,sb);
        }
        
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] sa = data.split(",");
            Arrays.asList(sa);


            return myDeserialize(new LinkedList<String>(Arrays.asList(sa)));
        }

        // Decodes your encoded data to tree.
        public TreeNode myDeserialize(LinkedList<String> list) {
            if(list.isEmpty()){
                return null;
            }

            String str = list.removeFirst();
            if(str.equals("#")){
                return null;
            }
            //System.out.println(sa[i]);
            TreeNode<Integer> root = new TreeNode(Integer.parseInt(str));

            //TreeNode root = new TreeNode(str);

            root.left=myDeserialize(list);
            root.right=myDeserialize(list);

            return root;
        }
    }

}
