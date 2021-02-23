package com.tencent.algorithm.leetcode.tree.trieTree;


//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。
//
// 若无答案，则返回空字符串。
//
//
//
// 示例 1：
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释：
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
//
//
// 示例 2：
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
//
//
//
//
// 提示：
//
//
// 所有输入的字符串都只包含小写字母。
// words数组长度范围为[1,1000]。
// words[i]的长度范围为[1,30]。
//
// Related Topics 字典树 哈希表
// 👍 124 👎 0

import java.util.Arrays;

public class Solution720{
    public static void main(String[] args) {
        Solution solution = new Solution720().new Solution();


        System.out.println(
                solution.longestWord(
                        new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})
        );


        System.out.println(
                solution.longestWordBySort(
                        new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})
        );
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestWord(String[] words) {

            String longestword = "";
            int longlen = 0;

            Trie trie = new Trie();

            for(String word: words){                                     //依次插入string
                trie.insert(word);
            }

            for(String word: words){
                if(trie.isBuild(word) && word.length() > longlen){         //遍历后发现有更长的string满足条件，进行替换
                    longestword = word;
                    longlen = word.length();
                }else if(trie.isBuild(word) && word.length() == longlen){     //当出现一样长的字符串时，进行比较
                    char[] longestchar = longestword.toCharArray();
                    char[] wordchar = word.toCharArray();
                    for(int i=0; i<longlen; i++){
                        if(wordchar[i]-longestchar[i] < 0){
                            longestword = word;
                            break;
                        }else if(wordchar[i]-longestchar[i] > 0) break;
                    }
                }
            }
            return longestword;

        }


        public String longestWordBySort(String[] words) {
            if(words==null || words.length==0) return "";
            Arrays.sort(words);
            String curr = "", prev = " ";
            int max = 0;
            for(int i=0;i<words.length;i++){
                curr = words[i];
                if((curr.startsWith(prev) && curr.length()==prev.length()+1)){
                    if(curr.length()>words[max].length()){
                        max = i;
                    }
                    prev = curr;
                }
                else{
                    if(curr.length()==1) prev = curr;
                    else if(curr.charAt(0)==prev.charAt(0)
                            && prev.length()>=curr.length()
                            && curr.substring(0,curr.length()-1).equals(prev.substring(0,curr.length()-1)))
                        prev = curr;
                    else prev = prev;
                }
            }
            return words[max];

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}