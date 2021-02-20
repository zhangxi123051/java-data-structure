package com.tencent.algorithm.leetcode.recursion;

import com.tencent.algorithm.array.Array;
import com.tencent.algorithm.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution206 {


    /*
     双指针
     1 2 3 4 5
     1和5 互换
     2和4 互换
     */
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        else                                        // 有两个以上结点
        {
            ListNode new_head = reverse(head.next); // 反转以第二个结点为头的子链表

            // head->next 此时指向子链表的最后一个结点

            // 将之前的头结点放入子链尾
            head.next.next = head;
            head.next = null;

            return new_head;
        }
    }

    public ListNode reverse2(ListNode head){
       List<Integer> temp = new ArrayList<>();
       ListNode tmp=head;
       while(tmp!=null){
           temp.add(tmp.val);
           tmp=tmp.next;
       }
       tmp = head;
       for(int i=temp.size()-1;i>=0;i--){
         tmp.val=temp.get(i);
         tmp=tmp.next;
       }

       return head;
    }


    /*
    迭代法
     新建一个表头 遍历原来的链表 每次插入到头部的前面即可
     */
    public ListNode reverse3(ListNode head){
        List<Integer> temp = new ArrayList<>();
        ListNode tmp=head;
        while(tmp!=null){
            temp.add(tmp.val);
            tmp=tmp.next;
        }
        tmp = head;
        for(int i=temp.size()-1;i>=0;i--){
            tmp.val=temp.get(i);
            tmp=tmp.next;
        }

        return head;
    }

    public static void main(String args[]){
        Solution206 solution= new Solution206();
        ListNode head = ListNode.createList(new int[]{1,2,3,4,5});
        ListNode tmp =head;
        while (tmp!=null){
            System.out.print(tmp.val+ " ");
            tmp=tmp.next;
        }

        System.out.print("\n");
//        head =solution.reverse2(head);
//
//        tmp =head;
//        while (tmp!=null){
//            System.out.print(tmp.val+ " ");
//            tmp=tmp.next;
//        }

        head =solution.reverse(head);
        tmp =head;
        while (tmp!=null){
            System.out.print(tmp.val+ " ");
            tmp=tmp.next;
        }

    }

}
