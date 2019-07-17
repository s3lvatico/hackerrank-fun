package tech.jore.hrpg.graph;

public final class GraphBuilder {

    public static Graph buildEmptyGraph(int maxVertexes) {
        if (maxVertexes < 0) {
            throw new IllegalArgumentException("negative number of vertexes specified");
        }

        return null; // TODO buildEmptyGraph(int)
    }

    public static Graph buildGraph(InputStream in) {
        return null; // TODO buildGraph(InputStream)
    }

}