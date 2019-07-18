package tech.jore.hrpg.graph;

import java.io.InputStream;
import java.util.Scanner;

public final class GraphBuilder {

    public static Graph buildEmptyGraph(int vertexes) {
        if (vertexes < 0) {
            throw new IllegalArgumentException("negative number of vertexes specified");
        }

        return new GraphImpl(vertexes);
    }

    public static Graph buildGraph(InputStream in) {
        try (Scanner s = new Scanner(in)) {
            int vertexes = s.nextInt();

            GraphImpl g = new GraphImpl(vertexes);

            int edges = s.nextInt();

            for (int i = 0; i < edges; i++) {
                int v = s.nextInt();
                int w = s.nextInt();
                g.addEdge(v, w);
            }

            return g;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}