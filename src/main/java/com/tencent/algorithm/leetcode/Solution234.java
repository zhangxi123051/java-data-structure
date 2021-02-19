package com.tencent.algorithm.leetcode;

//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 855 👎 0

import com.tencent.algorithm.leetcode.util.ListNode;

public class Solution234{
    public static void main(String[] args) {
        Solution solution = new Solution234().new Solution();
        ListNode head = ListNode.createList(new int[]{1,2,1,2});
        System.out.println("isPalindrome="+solution.isPalindrome(head));;

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /*
         快慢指针
         栈

         */
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode slow = head;
            ListNode fast = head;
            //找到中间结点
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow.next;
            ListNode reviseroot = new ListNode(0);//定义一个虚结点来接受逆转后的头结点
            ListNode cur = reviseroot;//搬运结点。
            while (mid != null) {//开始逆转
                cur = mid;
                mid = mid.next;
                cur.next = null;
                cur.next = reviseroot.next;
                reviseroot.next = cur;
            }
            slow = head;
            fast = reviseroot.next;
            while (fast != null) {//进行比较
                if (fast.val != slow.val) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        /*
        数组的办法
         */
        public boolean isPalindrome2(ListNode head) {
            if(head == null) return true;
            int count = 0;
            ListNode cur = head;
            while(head != null){
                count++;
                head = head.next;
            }
            int[] number = new int[count];
            count = 0;
            while(cur != null){
                number[count++] = cur.val;
                cur = cur.next;
            }
            int i = 0, j = number.length - 1;
            while(i <= j){
                if(number[i] != number[j]) return false;
                i++; j--;
            }
            return true;
        }
    }
}