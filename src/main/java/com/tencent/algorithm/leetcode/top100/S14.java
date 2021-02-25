package com.tencent.algorithm.leetcode.top100;

import java.util.Arrays;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

 

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 

提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成

排序 然后查找

 */
public class S14 {

    /*
      排序后 对比第一个和最后一个即可
     */
    class Solution {
        public String longestCommonPrefix(String[] strs) {
         Arrays.sort(strs);

         return "";
        }
    }

    /*
    纵向对比
     */
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            char[] chars = strs[0].toCharArray();
            boolean flag= true;
            int index=0;
            for(int i=0;i<chars.length;i++){
                index=i;
                for(String str:strs){
                   if(str.length()-1 <i ||  str.charAt(i) !=chars[i]){
                       index=i-1;
                       flag=false;
                       break;
                   }
                }
                if(flag== false)
                    break;
            }


            return strs[0].substring(0,index);
        }
    }
}
