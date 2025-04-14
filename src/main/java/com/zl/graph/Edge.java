package com.zl.graph;

/**
 */
public class Edge<V> {

    public int weight;
    public GraphNode<V> from;
    public GraphNode<V> to;

    public Edge(int weight, GraphNode<V> from, GraphNode<V> to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
