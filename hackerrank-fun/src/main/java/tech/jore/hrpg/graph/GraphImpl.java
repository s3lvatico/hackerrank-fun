package tech.jore.hrpg.graph;

import tech.jore.hrpg.Bag;
import tech.jore.hrpg.BagFactory;

class GraphImpl extends AbstractGraph  {

    private static final String LINE_SEP = System.getProperty("line.separator");

    private int edges;
    private Bag<Integer>[] adj; // adiacenze

    @SuppressWarnings("unchecked")
    GraphImpl(int vertexes) {
        super(vertexes);
        this.edges = 0;

        // unchecked cast, warning soppresso
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
        if (validateVertex(v) && validateVertex(w)) {
            adj[v].add(w);
            edges++;
        } else {
            System.err.println("at least one invalid vertex was specified");
        }
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