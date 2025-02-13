package com.zl.newhand.tree;

/**
 * 树节点
 */
public class TreeNode<V> {

    public V value;

    public TreeNode<V> left;

    public TreeNode<V> right;

    public TreeNode(V value) {
        this.value = value;
    }
}
