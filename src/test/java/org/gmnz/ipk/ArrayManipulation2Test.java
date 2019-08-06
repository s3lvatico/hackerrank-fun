package org.gmnz.ipk;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ArrayManipulation2Test extends BasicTest {

   private static final Logger log = LogManager.getLogger();

   @Test
   public void testInput14() throws Exception {

      StringBuilder sbOutputFilePath = new StringBuilder(this.getClass().getSimpleName());
      sbOutputFilePath.append("-").append("input14-out-").append(System.currentTimeMillis()).append(".txt");
      StringBuilder sbOutputPath = new StringBuilder(ArrayManipulation2Test.class.getResource("/").getPath());
      sbOutputPath.append(sbOutputFilePath.toString());

      Map<String, String> processEnvironment = new HashMap<>();
      processEnvironment.put("OUTPUT_PATH", sbOutputPath.toString());

      ProcessBuilder pb = prepareForExecution(ArrayManipulation2.class, "/arrman/input/input14.txt",
            processEnvironment);

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      logStdOutFromProcess(p);

      p.waitFor();

      p.destroy();
      log.info("Process ended");

   }

   // @Test
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

   // @Test
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