package tech.jore.hrpg.graph;

public final class GraphSearchFactory {

   public static GraphSearch depthFirstSearch(Graph g, int sourceVertex) {
      if (g == null) {
         System.err.println("null graph");
         return null;
      }
      if (sourceVertex < 0) {
         System.err.println("invalid vertex specified");
         return null;
      }

      if (g.hasVertex(sourceVertex)) {
         DfsSearch dfs = new DfsSearch();
         dfs.init(g, sourceVertex);
         return dfs;
      } else {
         return null;
      }
   }

}