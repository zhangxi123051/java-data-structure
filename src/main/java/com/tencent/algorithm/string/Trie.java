package com.tencent.algorithm.string;


public class Trie {
    private TrieNode root = new TrieNode('/'); // 存储无意义字符

    // 往Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // 在Trie树中查找一个字符串
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false) return false; // 不能完全匹配，只是前缀
        else return true; // 找到pattern
    }

    // 在Trie树中查找一个字符串
    public boolean findPrefix(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        return true; // 找到pattern
    }

    //计算最长公共子串
    public String getMaxPrefix() {
        TrieNode p = root;
//        for (int i = 0; i < pattern.length; ++i) {
//            int index = pattern[i] - 'a';
//            if (p.children[index] == null) {
//                return false; // 不存在pattern
//            }
//            p = p.children[index];
//        }
        return ""; // 找到pattern
    }



    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    public  static void main(String[] args){
        String[] array = new  String[]{"hello","hi","hero"};

        Trie trie = new Trie();

        for(String s:array){
//            System.out.println(s);
            trie.insert(s.toCharArray());
        }

        System.out.println(trie.findPrefix("hem".toCharArray()));


    }
}
