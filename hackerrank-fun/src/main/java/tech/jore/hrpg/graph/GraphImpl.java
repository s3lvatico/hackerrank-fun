package tech.jore.hrpg.graph;

import tech.jore.hrpg.Bag;
import tech.jore.hrpg.BagFactory;

class GraphImpl implements Graph {

    // TODO aggiungi il separatore di linea che può far comodo

    private final int vertexes;
    private int edges;
    private Bag<Integer>[] adj; // adiacenze

    /**
     * inizializza un nuovo grafo con {@code vertexes} vertici e 0 archi
     * 
     * @param vertexes numero di vertici; deve essere non negativo, pena
     *                 {@link IllegalArgumentException}
     */
    Graph(int vertexes) {
      

        this.vertexes = vertexes;
        this.edges = 0;

        adj = (Bag<Integer>[]) new Bag[vertexes];

        for (int v = 0; v < vertexes; v++) {
            adj[v] = BagFactory.newIntegerBag();
        }
    }

}