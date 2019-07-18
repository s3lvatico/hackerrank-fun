package tech.jore.hrpg.graph;

public interface Graph {

    int countVertexes();

    int countEdges();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

}