package tech.jore.hrpg.graph;

public interface Graph {

    int countVertexes();

    int countEdges();

    Iterable<Integer> adj(int v);

}