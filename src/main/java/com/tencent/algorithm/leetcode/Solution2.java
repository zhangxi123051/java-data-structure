package com.tencent.algorithm.leetcode;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 5626 👎 0


import com.tencent.algorithm.leetcode.util.ListNode;

public class Solution2 {

    public static void main(String[] args) {
        Solution solution = new Solution2().new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next=new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next=new ListNode(4);

//        l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        l1= ListNode.createList(new int[]{9,9,9,9,9,9,9});
        l2= ListNode.createList(new int[]{9,9,9,9});

        l1= ListNode.createList(new int[]{2,4,3});
        l2= ListNode.createList(new int[]{5,6,4});

//        ListNode head1=l1;
//        while (head1!=null){
//            System.out.println(head1.val);
//            head1=head1.next;
//        }
//
//        ListNode head2=l2;
//        while (head2!=null){
//            System.out.println(head2.val);
//            head2=head2.next;
//        }


        //ListNode result =solution.addTwoNumbers(l1,l2);

        ListNode result =solution.recursionAddTwoNumbers(l1,l2,0);
        while (result!=null){
            System.out.println("num="+result.val);
            result=result.next;
        }
    }


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int remain=0;
            ListNode result=new ListNode((remain+l1.val+l2.val)%10);
            ListNode tmp = result;
            remain=(l1.val+l2.val)/10;
            l1=l1.next;
            l2=l2.next;

            while(l1 !=null && l2 !=null){
                result.next=new ListNode((remain+l1.val+l2.val)%10);
                result= result.next;
                remain=(l1.val+l2.val)/10;
                l1=l1.next;
                l2=l2.next;
            }
            while(l1 !=null && l2==null){
                result.next=new ListNode((remain+l1.val)%10);
                result= result.next;
                remain=(l1.val+remain)/10;
                l1=l1.next;
            }

            while(l2 !=null && l1==null){
                result.next=new ListNode((remain+l2.val)%10);
                result= result.next;
                remain=(l2.val+remain)/10;
                l2=l2.next;
            }

            if(remain >0){
                result.next= new ListNode(remain);
            }

            return tmp;
        }

        public ListNode recursionAddTwoNumbers(ListNode l1, ListNode l2,int remain) {
            ListNode result = new ListNode((l1.val+l2.val+remain)%10);
            remain=(l1.val+l2.val+remain)/10;
            if(l1.next!=null || l2.next !=null || remain != 0){
                l1=l1.next == null ?new ListNode(0):l1.next;
                l2=l2.next== null ?new ListNode(0):l2.next;

                result.next=recursionAddTwoNumbers(l1,l2,remain);
            }


            return result;
        }
    }

}
