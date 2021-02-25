package com.tencent.algorithm.leetcode.top100;

import com.tencent.algorithm.leetcode.util.ListNode;
import com.tencent.algorithm.linkedlist.LinkedListAlgo;

import java.util.List;

public class S21 {
    public static void main(String[] args) {
        S21.Solution solution = new S21().new Solution();

        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        ListNode result = solution.mergeTwoLists(null,null);
        while(result !=null){
            System.out.print(result.val+",");
            result=result.next;

        }

    }
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null && l2 ==null)
                return null;

            if(l1==null && l2!=null){
                return l2;
            }
            if(l1!=null && l2==null){
                return l1;
            }

            ListNode head=null;
            //初始化第一个节点 链表头部
            if(l1.val <= l2.val){
                head=l1;
                l1=l1.next;
            }else{
                head=l2;
                l2=l2.next;
            }
            ListNode tmp =head;

            while(l1 !=null || l2!=null){
                if(l1 ==null && l2!=null){
                    tmp.next=l2;
                    break;
                }else if(l1!=null && l2==null){
                    tmp.next=l1;
                    break;
                }else{
                    if(l1.val <= l2.val){
                        tmp.next=l1;
                        tmp=tmp.next;
                        l1=l1.next;
                    }else{
                        tmp.next=l2;
                        tmp=tmp.next;
                        l2=l2.next;
                    }
                }


            }

            return head;
        }
    }

}
