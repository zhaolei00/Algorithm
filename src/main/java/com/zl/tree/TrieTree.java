package com.zl.tree;

/**
 * 前缀树
 */
public class TrieTree {

    private final TrieNode1 root = new TrieNode1();

    public void add(String s) {
        if (s == null) {
            return;
        }
        char[] charArray = s.toCharArray();
        TrieNode1 node = root;
        int path;
        root.pass++;
        for (char c : charArray) {
            path = c - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new TrieNode1();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++; // 最后一个为字符串结尾
    }

    public void delete(String s) {
        if (s == null) {
            return;
        }
        if (select(s) == 0) {
            return;
        }
        TrieNode1 node = root;
        root.pass--;
        int path;
        for (char c : s.toCharArray()) {
            path = c - 'a';
            // 因为上面已经确定有了，这里没必要判空了
            if (--node.nexts[path].pass == 0) {
                node.nexts[path] = null;
                return; // 中间某个地方pass已经为0了，直接断掉，后面不用再继续了。
            }
            node = node.nexts[path];
        }
        node.end--;
    }

    public int select(String s) {
        if (s == null) {
            return 0;
        }
        TrieNode1 node = root;
        int path;
        for (char c : s.toCharArray()) {
            path = c - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.end;
    }

    public int selectPre(String s) {
        if (s == null) {
            return 0;
        }
        TrieNode1 node = root;
        int path;
        for (char c : s.toCharArray()) {
            path = c - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.pass;
    }
















    private static class TrieNode1 {
        public int pass;
        public int end;
        public TrieNode1[] nexts;

        public TrieNode1() {
            this.nexts = new TrieNode1[26];
        }
    }

}
