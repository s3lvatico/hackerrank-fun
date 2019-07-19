package tech.jore.hrpg.graph;

public interface GraphSearch {
   /**
    * avvia la ricerca nel grafo a partire dal vertice specificato
    */
   void init(Graph g, int sourceVertex);

   /**
    * determina se il vertice specificato è connesso col vertice iniziale
    * 
    * @param vertex
    * @return
    */
   boolean isConnectedToSource(int vertex);

   /**
    * fornisce la dimensione del componente connesso che contiene il vertice
    * iniziale
    */
   int countConnectedVertexes();
   
}