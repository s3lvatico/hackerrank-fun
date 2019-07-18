package tech.jore.hrpg.graph;

import tech.jore.hrpg.Bag;
import tech.jore.hrpg.BagFactory;

class GraphImpl implements Graph {

    private final int vertexes;
    private int edges;
    private Bag<Integer>[] adj; // adiacenze

    GraphImpl(int vertexes) {
        this.vertexes = vertexes;
        this.edges = 0;

        adj = (Bag<Integer>[]) new Bag[vertexes];

        for (int v = 0; v < vertexes; v++) {
            adj[v] = BagFactory.newIntegerBag();
        }
    }

    public int countVertexes() {
        return vertexes;
    }

    public int countEdges() {
        return edges;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}