package tech.jore.hrpg.graph;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

   private static final String TEST_RESOURCE = "/graph-13.txt";

   @Test
   public void dummy() {
      Assert.assertTrue(true);
   }

   @Test
   public void readFromFile() {
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
}