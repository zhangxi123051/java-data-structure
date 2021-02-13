package com.tencent.plan.leetcode;


//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 489 👎 0

import java.util.ArrayList;
import java.util.List;

public class Solution77 {

     class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result= new ArrayList<>();
            compute(n,k,result,1,new ArrayList<Integer>());
            return result;
        }
        private void compute(int n,int k,List<List<Integer>> result,
                             int begin,ArrayList<Integer> list){
            if(list.size() == k){
                result.add(new ArrayList<Integer>(list));
                return;
            }

            for(int i=begin;i<=n;i++){
                list.add(i);
                compute(n,k,result,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> result=((new Solution77()).new Solution()).combine(4,3);

        System.out.println(result.toString());
//        for(List<Integer> item:result){
//            System.out.println(item.toString());
//        }
    }
}
