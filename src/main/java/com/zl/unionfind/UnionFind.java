package com.zl.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionFind {

    public static class UnionNode<V> {
        public V value;

        public UnionNode(V value) {
            this.value = value;
        }
    }

    // 还有数组实现，数组实现适用于V是int值。
    //      否则还需要个map还记录数组位置代表的是哪个元素。或者能根据一个公式，映射成对应位置。
    //      这是两个策略。在数组很小的时候，用数组。如果很大，用HashMap。
    public static class UnionSet<V> {
        private final Map<V, UnionNode<V>> nodes;

        private final Map<UnionNode<V>, UnionNode<V>> parent;

        private final Map<UnionNode<V>, Integer> sizeMap;

        public UnionSet(List<V> list) {
            nodes = new HashMap<>();
            parent = new HashMap<>();
            sizeMap = new HashMap<>();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (V v : list) {
                UnionNode<V> node = new UnionNode<>(v);
                nodes.put(v, node);
                parent.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        // 找到代表节点
        private UnionNode<V> findFather(UnionNode<V> cur) {
            Stack<UnionNode<V>> stack = new Stack<>();
            while (cur != parent.get(cur)) {
                stack.push(cur);
                cur = parent.get(cur);
            }
            // 只有一个时，不需要重新添加父亲，添加也是白添加。
            if (stack.size() > 1) {
                while (!stack.isEmpty()) {
                    parent.put(stack.pop(), cur);
                }
            }
            return cur;
        }

        public boolean isSameSet(V a, V b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            UnionNode<V> nodeA = findFather(nodes.get(a));
            UnionNode<V> nodeB = findFather(nodes.get(b));
            if (nodeA == nodeB) {
                return;
            }
            Integer sizeA = sizeMap.get(nodeA);
            Integer sizeB = sizeMap.get(nodeB);
            UnionNode<V> smallNode = sizeA < sizeB ? nodeA : nodeB;
            UnionNode<V> bigNode = smallNode == nodeA ? nodeB : nodeA;
            // 小挂大
            parent.put(smallNode, bigNode);
            sizeMap.put(bigNode, sizeA + sizeB);
            sizeMap.remove(smallNode);
        }

        public int size() {
            return sizeMap.size();
        }
    }

    public static class UnionSet1 {
        // i 位置的父亲在哪个位置
        private final int[] parent;
        // i 位置的集合大小
        private final int[] size;

        private final int[] help;

        // 集合数量
        private int setNum;

        public UnionSet1(int n) {
            parent = new int[n];
            size = new int[n];
            help = new int[n];
            setNum = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 找到代表节点
        private int findFather(int cur) {
            int h = 0;
            while (cur != parent[cur]) {
                help[h++] = cur;
                cur = parent[cur];
            }
            for (int i = h - 1; i >= 0; i--) {
                parent[help[i]] = cur;
            }
            return cur;
        }

        public boolean isSameSet(int a, int b) {
            return findFather(a) == findFather(b);
        }

        public void union(int a, int b) {
            int fatherA = findFather(a);
            int fatherB = findFather(b);
            if (fatherA == fatherB) {
                return;
            }
            int sizeA = size[fatherA];
            int sizeB = size[fatherB];
            int small = sizeA < sizeB ? fatherA : fatherB;
            int big = small == fatherA ? fatherB : fatherA;
            parent[small] = big;
            size[big] = sizeA + sizeB;
            size[small] = 0;
            setNum--;
        }

        public int size() {
            return setNum;
        }
    }

}
