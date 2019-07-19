package tech.jore.hrpg.graph;

abstract class AbstractGraph implements Graph {
   protected final int vertexes;

   AbstractGraph(int vertexes) {
      this.vertexes = vertexes;
   }

   protected boolean validateVertex(int v) {
      return v >= 0 && v < vertexes;
   }

   public boolean hasVertex(int v) {
      return validateVertex(v);
  }
}