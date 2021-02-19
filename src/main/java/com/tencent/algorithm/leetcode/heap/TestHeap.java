package com.tencent.algorithm.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class TestHeap {

    public static  void main(String args[]){
        //最小堆 一般求最大的k个元素
        PriorityQueue<Integer> minHeap=  new PriorityQueue<Integer>();

        //最大堆 一般用来计算最小的第k的元素
        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());


        int[] nums = new int[]{3,2,1,5,6,4,5,5,7};
        int k=4;
        for(int i=0;i<nums.length;i++){
//            minHeap.add(i);
//            if(minHeap.size() >k){
//                minHeap.poll();
//            }
            if(i<k){
                minHeap.add(nums[i]);
            }else{
                if(minHeap.peek() <nums[i]){
                    minHeap.add(nums[i]);
                    minHeap.poll();
                }
            }
        }

        System.out.println(minHeap.peek());
    }
}
