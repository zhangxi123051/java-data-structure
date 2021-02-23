package com.tencent.algorithm.leetcode.tree.trieTree;

class Trie{
    TrieNode root = new TrieNode('/');

    public void insert(String string){             //用来插入一个string
        char[] ccc = string.toCharArray();
        TrieNode p = root;
        for(int i=0; i<ccc.length; i++){
            int index = ccc[i] - 'a';
            if(p.next[index] == null){
                TrieNode trienode = new TrieNode(ccc[i]);
                p.next[index] = trienode;
            }
            p = p.next[index];
        }
        p.isword = true;
    }

    public boolean isBuild(String string){            //用来判断这个字符串是不是由其他节点依次加一个字符组成
        char[] ccc = string.toCharArray();
        TrieNode p = root;
        for(int i=0; i<ccc.length; i++){
            if(!p.next[ccc[i]-'a'].isword) return false;
            p = p.next[ccc[i]-'a'];
        }
        return true;
    }




    class TrieNode{
        public char data;
        public boolean isword = false;
        public TrieNode[] next = new TrieNode[26];
        public TrieNode(char c){
            data = c;
        }
    }
}
