package tech.jore.hrpg.graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

   Logger logger = LogManager.getLogger(GraphTest.class);

   private static final String TEST_RESOURCE = "/graph-13.txt";

   @Test
   public void dummy() {
      Assert.assertTrue(true);
   }

   @Test
   public void readFromFile() {
      logger.info("getting graph definition from {}", TEST_RESOURCE);
      InputStream in = GraphTest.class.getResourceAsStream(TEST_RESOURCE);
      Assert.assertNotNull(in);
      try (Scanner s = new Scanner(in)) {
         int v = s.nextInt();
         // per come è fatto il file di testo so che il primo numero è 13
         Assert.assertNotEquals(0, v);
         
      } catch (Exception e) {
         Assert.fail();
      }
   }
   
   @Test
   public void buildEmptyGraph() {
      Graph g = GraphBuilder.buildEmptyGraph(4);
      logger.info(g);
   }
   
   @Test
   public void createGraphFromDataFile() {
      logger.info("getting graph definition from {}", TEST_RESOURCE);
      try (InputStream in = GraphTest.class.getResourceAsStream(TEST_RESOURCE)) {
         Assert.assertNotNull(in);
         Graph g = GraphBuilder.buildGraph(in);
         logger.info(g);
      } catch (IOException e) {
         e.printStackTrace();
         Assert.fail();
      }
   }
   
}