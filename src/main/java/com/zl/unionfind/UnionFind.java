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
    }

}
