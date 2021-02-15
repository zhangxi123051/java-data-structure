package com.tencent.plan.leetcode;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表
// 👍 810 👎 0

import java.util.List;

public class Solution24{
    public static void main(String[] args) {
        Solution solution = new Solution24().new Solution();
        ListNode head=new Solution24().createList(new int[]{1,2,9,3,4,5});
        head=solution.swapPairs(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }


    }

    public ListNode createList(int[] nums){
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

    public class ListNode {
        int val;
        ListNode next=null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode result =head;
            if(head ==null){
                return null;
            }
            while(head!=null && head.next !=null){
                int swap = head.val;
                head.val=head.next.val;
                head.next.val=swap;

                head=head.next.next;
            }

            return result;

        }
    }

}