package com.zl.graph;

import java.util.List;

/**
 */
public class GraphNode<V> {

    public V value;
    public int in;

    public int out;
    public List<GraphNode<V>> nexts;

    public List<Edge<V>> edges;

}
