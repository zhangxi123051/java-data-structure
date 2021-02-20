package com.tencent.algorithm.leetcode.slidwindow;

//给你字符串 s 和整数 k 。
//
// 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
//
// 英文中的 元音字母 为（a, e, i, o, u）。
//
//
//
// 示例 1：
//
// 输入：s = "abciiidef", k = 3
//输出：3
//解释：子字符串 "iii" 包含 3 个元音字母。
//
//
// 示例 2：
//
// 输入：s = "aeiou", k = 2
//输出：2
//解释：任意长度为 2 的子字符串都包含 2 个元音字母。
//
//
// 示例 3：
//
// 输入：s = "leetcode", k = 3
//输出：2
//解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
//
//
// 示例 4：
//
// 输入：s = "rhythms", k = 4
//输出：0
//解释：字符串 s 中不含任何元音字母。
//
//
// 示例 5：
//
// 输入：s = "tryhard", k = 4
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10^5
// s 由小写英文字母组成
// 1 <= k <= s.length
//
// Related Topics 字符串 Sliding Window
// 👍 14 👎 0

import java.util.HashSet;
import java.util.Set;

public class Solution1456{
    public static void main(String[] args) {
        Solution solution = new Solution1456().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        滑动窗口来计算
         */
        public int maxVowels(String s, int k) {

            if(s.length() < k){
                return 0;
            }

            Set<Character> vowel = new HashSet<>();
            vowel.add('a');
            vowel.add('e');
            vowel.add('i');
            vowel.add('o');
            vowel.add('u');



            int i=0,j=k-1;
            int result=0;
            int count=0;
            while(i <s.length()){

            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}