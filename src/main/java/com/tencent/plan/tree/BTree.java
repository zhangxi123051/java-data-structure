package com.tencent.plan.tree;

import java.util.LinkedList;
import java.util.Queue;

class Tree<T> {
    public Tree left;
    public Tree right;
    public T data;

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
        Tree<String> e= new Tree<String>("E");
        Tree<String> f = new Tree<String>("F");
        Tree<String> g = new Tree<String>("G");

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
