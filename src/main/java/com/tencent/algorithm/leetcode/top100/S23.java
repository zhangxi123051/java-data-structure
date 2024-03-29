package com.tencent.algorithm.leetcode.top100;

import com.tencent.algorithm.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class S23 {

    public static void main(String[] args) {
        S23.Solution solution = new S23().new Solution();

        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2 = new ListNode(1);
//        l2.next=new ListNode(3);
//        l2.next.next=new ListNode(4);

//        ListNode[]  lists = new ListNode[]{null,l2};
//        lists.add(null);
//        lists.add(l2);

        ListNode result = solution.mergeKLists(new ListNode[]{null,l2});
        while(result !=null){
            System.out.print(result.val+",");
            result=result.next;

        }

    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length ==0){
                return null;
            }
            ListNode ans=null;
            for(int i=0;i<lists.length;i++){
                ans=mergeTwoLists(ans,lists[i]);
            }
            return ans;
        }


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null && l2 ==null)
                return null;

            if(l1==null && l2!=null){
                return l2;
            }
            if(l1!=null && l2==null){
                return l1;
            }

            ListNode head=new ListNode(-1);
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

            return head.next;
        }
    }
}
