package com.tencent.algorithm.leetcode.top100;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
 

提示：

1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class S22 {

    public static void main(String[] args) {
        S22.Solution solution = new S22().new Solution();
        System.out.println(solution.generateParenthesis(6));

        for(String str:solution.generateParenthesis(6)){
            if(solution.isFlag(str)){
                System.out.println(str);
            }
        }

    }

    class Solution {

        //List<String> res=new ArrayList<>();
        //StringBuilder sb=new StringBuilder();

        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            String[]  strs = new String[]{"(",")"};
            dfs(n,0,new StringBuilder(),strs,result);

            //遍历result，看是否满足括号的条件
            return result;
        }

        public void dfs(int n,int cur,StringBuilder sb, String[]  strs,List result){
            if(cur == n){
                result.add(sb.toString());
                return;
            }

            for(int i=0;i<strs.length;i++){
                sb.append(strs[i]);
                dfs(n,cur+1,sb,strs,result);
                sb.deleteCharAt(cur);
            }

        }
        public boolean isFlag(String s){
            if(s.charAt(0) ==')' || s.charAt(s.length()-1) =='('){
                return false;
            }

            Stack<Character> stack = new Stack();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) =='('){
                    stack.push(s.charAt(i));
                }else if (s.charAt(i) ==')'){
                    if(stack.size() ==0 || stack.peek() !='(' ){
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.size()>0? false:true;
        }


        public boolean isValid(String s) {
            return  false;
        }

    }
}
