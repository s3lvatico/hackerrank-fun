package org.gmnz.ipk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ArrayManipulationTest {

   private static final Logger log = LogManager.getLogger();

   private ProcessBuilder prepareForExecution(Class<?> targetClass, String strInputFileUrl,
         Map<String, String> environment) throws URISyntaxException {
      ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", targetClass.getName());
      log.info("ProcessBuilder created for execution of class {}", targetClass.getName());

      File f = new File(ArrayManipulationTest.class.getResource(strInputFileUrl).toURI());
      log.info("input file to the test target :  {}", f);
      log.debug("exists? : " + f.exists());

      if (environment != null) {
         pb.environment().putAll(environment);
      }

      pb.redirectInput(f);
      pb.redirectErrorStream(true);

      return pb;
   }

   private ProcessBuilder prepareForExecution(Class<?> targetClass, String strInputFileUrl) throws URISyntaxException {
      return prepareForExecution(targetClass, strInputFileUrl, null);
   }

   private void logStdOutFromProcess(Process p) throws IOException {
      BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
      try {
         String readLine;
         while ((readLine = r.readLine()) != null) {
            log.info(readLine);
         }
      } finally {
         r.close();
      }
   }

   @Test
   public void testInput14() throws Exception {

      ProcessBuilder pb = prepareForExecution(ArrayManipulation.class, "/arrman/input/input14.txt");

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      logStdOutFromProcess(p);

      p.waitFor();

      p.destroy();
      log.info("Process ended");

   }

   @Test
   public void testInput00() throws Exception {

      ProcessBuilder pb = prepareForExecution(ArrayManipulation.class, "/arrman/input/input00.txt");

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      logStdOutFromProcess(p);

      p.waitFor();

      p.destroy();
      log.info("Process ended");

   }

   @Test
   public void testInput15() throws Exception {

      ProcessBuilder pb = prepareForExecution(ArrayManipulation.class, "/arrman/input/input15.txt");

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      logStdOutFromProcess(p);

      p.waitFor();

      p.destroy();
      log.info("Process ended");

   }
}