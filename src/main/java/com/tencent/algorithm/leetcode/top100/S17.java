package com.tencent.algorithm.leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 

提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */

public class S17 {

    public static void main(String[] args) {
        Solution solution = new S17().new Solution();
        System.out.println(solution.letterCombinations("23"));




    }
    class Solution {
        Map<Character, String> phoneMap= new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if(digits.length()==0){
                return res;
            }

            dfs(0,digits);
            return res;
        }
        private void dfs(int cur,String digits){
            if(cur==digits.length()){
                res.add(sb.toString());
                return;
            }
            String str=phoneMap.get(digits.charAt(cur));
            for(int i=0;i<str.length();i++){
                sb.append(str.charAt(i));
                dfs(cur+1,digits);
                sb.deleteCharAt(cur);
            }
        }
    }


}
