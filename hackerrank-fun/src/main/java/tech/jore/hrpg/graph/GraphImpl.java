package tech.jore.hrpg.graph;

import tech.jore.hrpg.Bag;
import tech.jore.hrpg.BagFactory;

class GraphImpl implements Graph {

    private static final String LINE_SEP = System.getProperty("line.separator");

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
        edges++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Maximum vertexes : " + vertexes).append(LINE_SEP);
        sb.append("Edges : " + edges).append(LINE_SEP);
        for (int v = 0; v < vertexes; v++) {
            if (adj[v].size() > 0) {
                sb.append(v + ":");
                for (int w : adj[v]) {
                    sb.append(" " + w);
                }
                sb.append(LINE_SEP);
            }
        }
        sb.append(LINE_SEP);
        return sb.toString();
    }
}