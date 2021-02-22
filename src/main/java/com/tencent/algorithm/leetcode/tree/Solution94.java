package com.tencent.algorithm.leetcode.tree;



//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[2,1]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 857 👎 0

import com.tencent.algorithm.leetcode.util.TreeNode;

import java.sql.PreparedStatement;
import java.util.*;

public class Solution94 {
    public static void main(String[] args) {
        Solution solution = new Solution94().new Solution();
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left=new TreeNode<Integer>(2);;
        root.right=new TreeNode<Integer>(7);

        root.left.left=new TreeNode<Integer>(4);;
        root.left.right=new TreeNode<Integer>(3);
        root.right.left=new TreeNode<Integer>(6);
        root.right.right=null;

//        System.out.println(solution.inorderTraversal(root));
//
//
//        System.out.println(solution.inorderTraversalNoRecur(root));

//        System.out.println("前序遍历:"+solution.preOrderTraversal(root));
//        System.out.println("前序遍历2:"+solution.preOrderTraversal(root));


        System.out.println("后序遍历:"+solution.postOrderTraversalNoRecur2(root));

        //System.out.println(solution.levelOrder(root));

        System.out.println(solution.sum(root,5,9));

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
        private List<Integer> list;

        public  Solution() {
            this.list = new ArrayList<Integer>();
        }


        //求和
        public int sum(TreeNode<Integer> root,int low,int high) {
            if(root ==null){
                return 0;
            }
            if(root.val >=high || root.val<= low){
                return sum(root.left,low,high)+sum(root.right,low,high);
            }else{
                return root.val+sum(root.left,low,high)+sum(root.right,low,high);
            }
        }


        public int getHeight(TreeNode<Integer>  root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(getHeight(root.right), getHeight(root.left));
        }


        public int getLevel(TreeNode<Integer>  root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(getLevel(root.right), getLevel(root.left));
        }


        public List<List<Integer>> levelOrder(TreeNode root) {
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


        //层次遍历 数组输出 查看层次
        public List<List<Integer>> levelTraversal2(TreeNode<Integer> root) {
            List<List<Integer> > result = new ArrayList<>();
            if(root !=null){
                Queue<TreeNode<Integer>> queue = new PriorityQueue<>();
                queue.add(root);

                while(queue.size()>0){
                    TreeNode<Integer> tmpNode = queue.poll();
                    //处理当前节点
                    if(tmpNode !=null){
                        System.out.println("Height="+getHeight(tmpNode));
                        try{
                            result.get(getHeight(tmpNode)).add(tmpNode.val);
                        }catch(Exception e){
                            List<Integer> data = new ArrayList<>();
                            data.add(tmpNode.val);
                            result.set(getHeight(tmpNode),data);
                        }

//                        if(result.get(getHeight(tmpNode)) ==null){
//                            List<Integer> data = new ArrayList<>();
//                            data.add(tmpNode.val);
//                            result.add(data);
//                        }else{
//                            result.get(getHeight(tmpNode)).add(tmpNode.val);
//                        }

                    }

                    if(tmpNode.left !=null){
                        queue.add(tmpNode.left);
                    }
                    if(tmpNode.right !=null){
                        queue.add(tmpNode.right);
                    }

                }

            }

            return result;
        }


        //层次遍历
        public List<Integer> levelTraversal(TreeNode<Integer> root) {
            List<Integer>  result = new ArrayList<Integer>();
           if(root !=null){
               Queue<TreeNode<Integer>> queue = new PriorityQueue<>();
               queue.add(root);

               while(queue.size()>0){
                   TreeNode<Integer> tmpNode = queue.poll();
                   //处理当前节点
                   if(tmpNode !=null){
                       result.add(tmpNode.val);
                   }

                   if(tmpNode.left !=null){
                       queue.add(tmpNode.left);
                   }
                   if(tmpNode.right !=null){
                       queue.add(tmpNode.right);
                   }

               }

           }

            return result;
        }



        //中序遍历
        public List<Integer> inorderTraversal(TreeNode<Integer> root) {
            if(root ==null){
                return list;
            }

            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);

            return list;
        }


        /*
           非递归形式的二叉树中序遍历
         */
        public List<Integer> inorderTraversalNoRecur(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode<Integer> cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode<Integer> node = stack.pop();
                result.add(node.val);
                cur = node.right;
            }
            return result;
        }


        //前序遍历
        public List<Integer> preOrderTraversal(TreeNode<Integer> root) {
            if(root ==null){
                return list;
            }

            list.add(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);

            return list;
        }


        //前序遍历
        public List<Integer> presOrderTraversalNoRecur(TreeNode<Integer> root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {

                TreeNode<Integer> node = stack.pop();
                result.add(node.val);

                if(node.right !=null){
                    stack.push(node.right);
                }
                if(node.left !=null){
                    stack.push(node.left);
                }

            }
            return result;
        }


        //后序遍历
        public List<Integer> postOrderTraversal(TreeNode<Integer> root) {
            if(root ==null){
                return list;
            }


            postOrderTraversal(root.left);
            postOrderTraversal(root.right);

            list.add(root.val);

            return list;
        }

        //非递归实现二叉树的后序遍历
        public List<Integer> postOrderTraversalNoRecur(TreeNode<Integer> root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {

                TreeNode<Integer> node = stack.pop();
                result.add(node.val);




                if(node.left !=null){
                    stack.push(node.left);
                }

                if(node.right !=null){
                    stack.push(node.right);
                }

            }

            Collections.reverse(result);
            return result;
        }

        //非递归实现二叉树的后序遍历
        public List<Integer> postOrderTraversalNoRecur2(TreeNode<Integer> root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    res.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }



        //计算树的高度
    }
//leetcode submit region end(Prohibit modification and deletion)

}