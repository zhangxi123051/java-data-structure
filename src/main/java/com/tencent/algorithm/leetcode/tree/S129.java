package com.tencent.algorithm.leetcode.tree;

import apple.laf.JRSUIUtils;
import com.tencent.algorithm.leetcode.util.TreeNode;
import com.tencent.springaop.util.StringUtils;

import java.util.*;

public class S129 {
    public static void main(String[] args) {
        S129.Solution solution = new S129().new Solution();
        //TreeNode root =TreeNode.createTree();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        //root.left.left=new TreeNode(4);
        root.right=new TreeNode(3);
        //root.right.left=new TreeNode(5);
        System.out.println(TreeNode.preorderTraversal(root));

        System.out.println(solution.binaryTreePaths(root));

        System.out.println(solution.sumNumbers(root));


    }

    class Solution {


        public int sumNumbers(TreeNode root) {
            List<String> result = new ArrayList<>();
            dfs(root,  new LinkedList<>(),result);
            int sum=0;
            for(String str:result){
                sum=sum+Integer.parseInt(str);
            }
            return sum;
        }

        public List<String> binaryTreePaths(TreeNode root) {

            List<String> result = new ArrayList<>();
            dfs(root,  new LinkedList<>(),result);
            return result;
        }

        private void dfs(TreeNode root, String path, List<String> res) {
            //如果为空，直接返回
            if (root == null)
                return;
            //如果是叶子节点，说明找到了一条路径，把它加入到res中
            if (root.left == null && root.right == null) {
                res.add(path + root.val);
                return;
            }
            //如果不是叶子节点，在分别遍历他的左右子节点
            dfs(root.left, path + root.val + "->", res);
            dfs(root.right, path + root.val + "->", res);
        }



        public void dfs(TreeNode root, LinkedList res,List result){

            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                res.addLast(root.val+"");
                ;
                //res.append(root.val);
                result.add(String.join("",res));
                return;
            }


            res.addLast(root.val+"");

            if(root.left !=null) {
                dfs(root.left,res,result);
                res.removeLast();
            }

            if(root.right !=null) {
                dfs(root.right,res,result);
                res.removeLast();
            }
        }

    }

}
