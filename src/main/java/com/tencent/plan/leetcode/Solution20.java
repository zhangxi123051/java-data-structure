package com.tencent.plan.leetcode;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2154 👎 0

import java.util.Stack;

public class Solution20{
    public static void main(String[] args) {
        Solution solution = new Solution20().new Solution();

        System.out.println(solution.isValid("()[({})]{"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if(s.length() ==0){
                return true;
            }
            Stack<Character> stack = new Stack();

            for(int i=0;i<s.length();i++){
                char tmp = s.charAt(i);
                if(tmp=='(' || tmp =='{'|| tmp =='['){
                    stack.push(s.charAt(i));
                }
                if(tmp ==')' && stack.pop()!='('){
                    return  false;
                }

                if(tmp ==']' && stack.pop()!='['){
                    return  false;
                }

                if(tmp =='}' && stack.pop()!='{'){
                    return  false;
                }
            }
            if(stack.size() >0){
                return  false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}