package com.tencent.algorithm.leetcode.util;

public class ListNode {
    public int val;
    public ListNode next=null;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode createList(int[] nums){
        if(nums==null || nums.length==0){
            return null;
        }
        ListNode result= new ListNode(nums[0]);
        ListNode tmp=result;

        for(int i=1;i<nums.length;i++){
            result.next=new ListNode(nums[i]);
            result=result.next;
        }

        return tmp;
    }

}
