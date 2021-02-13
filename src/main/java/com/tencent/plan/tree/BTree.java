package com.tencent.plan.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
二叉树高度


226.翻转二叉树（简单）
114.二叉树展开为链表（中等）
116.填充每个节点的下一个右侧节点指针（中等）


654.最大二叉树（中等）
105.从前序与中序遍历序列构造二叉树（中等）
106.从中序与后序遍历序列构造二叉树（中等）


652.寻找重复的子树（中等）


----二叉搜索树（左子树小于右字树)
230.BST第K小的元素（中等）
538.二叉搜索树转化累加树（中等）
1038.BST转累加树（中等）

450.删除二叉搜索树中的节点（中等）
701.二叉搜索树中的插入操作（中等）
700.二叉搜索树中的搜索（简单）
98.验证二叉搜索树（中等）


297.二叉树的序列化和反序列化（困难）
  前序 中序 后序的序列化和反序列化
  层次遍历的序列化

341.扁平化嵌套列表迭代器（中等）

236.二叉树的最近公共祖先（中等）


树的遍历模型
void traverseTree(TreeNode root) {
    if (root == null) return;
    traverse(root.left);
    // 中序遍历代码位置
    print(root.val);
    traverse(root.right);
}

二叉搜索树的搜索模型
void traverseBST(TreeNode root, int target) {
    if (root.val == target)
        // 找到目标，做点什么
    if (root.val < target)
        BST(root.right, target);
    if (root.val > target)
        BST(root.left, target);
}
*/

class Tree<T> {
    public Tree left;
    public Tree right;
    public T data;
    public Tree next;//右侧指针

    public Tree(T data) {
        this.data = data;
    }

}

//    public static void levelPrint(Tree r){
//        if(r==null){
//            return;
//        }
//
//        System.out.print(r.data+" ");
//
//        levelPrint(r.left);
//        levelPrint(r.right);
////        if(r.left != null) {
////            System.out.print(r.left.data+" ");
////        }
////        if(r.right != null){
////            System.out.print(r.right.data+" ");
////        }
//    }
public class BTree {



    public static void PreOrder(Tree root){
        if(root==null) {return;}

        System.out.print(root.data+" ");

        PreOrder(root.left);
        PreOrder(root.right);

    }


    public static void InOrder(Tree root){
        if(root==null) return;

        InOrder(root.left);
        System.out.print(root.data+" ");

        InOrder(root.right);

    }

    public static void PostOrder(Tree root){
        if(root==null) return;


        PostOrder(root.left);
        PostOrder(root.right);

        System.out.print(root.data+" ");

    }

    /*
    构建最大二叉树
     */
    public static Tree  buildMaximumBinaryTree(int[] nums){

        return null;
    }

    /*
    通过前序和中序遍历结果构造二叉树
     */
    public static Tree  buildTree(int[] preOrder,int[] inOrder){

        return null;
    }

    /*
    通过后序和中序遍历结果构造二叉树
   */
    public static Tree  buildTree2(int[] postOrder,int[] inOrder){

        return null;
    }

    /*
     寻找重复的子树（中等）
     利用后序遍历的思路
     1.保存遍历时每颗子树到HashMap<String,int> 中
     同时用Hashset来存储相同子树的根节点
     */
    List<Tree> findDuplicateSubtrees(Tree root){
        return null;
    }


    /*
     最近的公共祖先
     */
    public static Tree lowestCommonAncestor(Tree root,Tree left,Tree right){

        return  null;
    }

    /*
     计算树的节点树
     */
    public static int countNodes(Tree root){
        if(root == null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }




    public static void LevelOrder(Tree root){
        if(root==null) return;
        Queue<Tree> queue=new LinkedList<Tree>();
        queue.add( root);
        while(!queue.isEmpty()){
            Tree node=queue.poll();
            System.out.print(node.data+" ");
            if(null!=node.left){
                queue.add(node.left);
            }
            if(null!=node.right){
                queue.add(node.right);
            }
        }

    }


    public static int maxDepth(Tree root){
        if(root==null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right) )+ 1;

    }


    public static void main(String[] args){
        Tree<String> root = new Tree<String>("A");
        Tree<String> b = new Tree<String>("B");
        Tree<String> c = new Tree<String>("C");
        Tree<String> d = new Tree<String>("D");
        Tree<String> e= new Tree<>("E");
        Tree<String> f = new Tree<String>("F");
        Tree<String> g = new Tree<>("G");

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;


//        levelOrder(a);
        System.out.println("----前序遍历--------");
        PreOrder(root);
        System.out.println("\n----前序遍历--------");

        System.out.println("中序遍历--------");
        InOrder(root);
        System.out.println("\n中序遍历--------");


        System.out.println("后序遍历--------");
        PostOrder(root);
        System.out.println("\n后序遍历--------");

        System.out.println("层次遍历--------");
        LevelOrder(root);
        System.out.println("\n层次遍历--------");


        System.out.println("\n树的高度-------"+maxDepth(root));

//        System.out.println(a.data);
    }

}
