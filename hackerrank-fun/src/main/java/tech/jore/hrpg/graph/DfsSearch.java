package tech.jore.hrpg.graph;

import java.util.Arrays;

class DfsSearch implements GraphSearch {

   private boolean[] marked;
   private Graph g;
   private int connectedVertexes;

   @Override
   public int countConnectedVertexes() {
      return connectedVertexes;
   }

   @Override
   public void init(Graph g, int sourceVertex) {
      connectedVertexes = 0;
      marked = new boolean[g.countVertexes()];
      Arrays.fill(marked, false);
      dfs(sourceVertex);
   }

   private void dfs(int v) {
      if (marked[v])
         return;
      marked[v] = true;
      connectedVertexes++;
      for (int w : g.adj(v)) {
         dfs(w);
      }
   }

   @Override
   public boolean isConnectedToSource(int vertex) {
      return marked[vertex];
   }

}