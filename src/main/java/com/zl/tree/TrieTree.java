package com.zl.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 */
public class TrieTree {

    private final TrieNode root = new TrieNode();

    public void add(String s) {
        if (s == null) {
            return;
        }
        char[] charArray = s.toCharArray();
        TrieNode node = root;
        Integer path;
        root.pass++;
        for (char c : charArray) {
            path = (int) c;
            if (node.nexts.get(path) == null) {
                node.nexts.put(path, new TrieNode());
            }
            node = node.nexts.get(path);
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
        TrieNode node = root;
        root.pass--;
        Integer path;
        for (char c : s.toCharArray()) {
            path = (int) c;
            // 因为上面已经确定有了，这里没必要判空了
            if (--node.nexts.get(path).pass == 0) {
                node.nexts.remove(path);
                return; // 中间某个地方pass已经为0了，直接断掉，后面不用再继续了。
            }
            node = node.nexts.get(path);
        }
        node.end--;
    }

    public int select(String s) {
        if (s == null) {
            return 0;
        }
        TrieNode node = root;
        int path;
        for (char c : s.toCharArray()) {
            path = (int) c;
            if (node.nexts.get(path) == null) {
                return 0;
            }
            node = node.nexts.get(path);
        }
        return node.end;
    }

    public int selectPre(String s) {
        if (s == null) {
            return 0;
        }
        TrieNode node = root;
        int path;
        for (char c : s.toCharArray()) {
            path = (int) c;
            if (node.nexts.get(path) == null) {
                return 0;
            }
            node = node.nexts.get(path);
        }
        return node.pass;
    }


    public static void main(String[] args) {

    }











    private static class TrieNode {
        public int pass;
        public int end;
        public Map<Integer, TrieNode> nexts;

        public TrieNode() {
            this.nexts = new HashMap<>();
        }
    }

}
