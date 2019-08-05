package org.gmnz.ipk;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class ArrayManipulationTest {

   private static final Logger log = LogManager.getLogger();

   @Test
   public void dummy() throws Exception {
      ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", ArrayManipulation.class.getName());
      log.info("ProcessBuilder created");

      File f = new File(ArrayManipulationTest.class.getResource("/arrman/input/input14.txt").toURI());
      System.out.println("le file : " + f);
      System.out.println("exists? : " + f.exists());
      pb.redirectInput(f);

      // System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!");

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String readLine;
      while ((readLine = r.readLine()) != null) {
         System.out.println("linea!");
         log.info(readLine);
      }

      p.waitFor();

      p.destroy();
      log.info("Process ended");

      r.close();

      Assert.assertTrue(true);

   }
}