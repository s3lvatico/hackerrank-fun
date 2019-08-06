package org.gmnz.ipk;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ArrayManipulation2Test extends BasicTest {

   private static final Logger log = LogManager.getLogger();

   private String createOutputPath(String outputId) {
      StringBuilder sbOutputFilePath = new StringBuilder(this.getClass().getSimpleName());
      sbOutputFilePath.append(String.format("-%s-", outputId)).append(System.currentTimeMillis()).append(".txt");
      StringBuilder sbOutputPath = new StringBuilder(ArrayManipulation2Test.class.getResource("/").getPath());
      sbOutputPath.append(sbOutputFilePath.toString());
      return sbOutputPath.toString();
   }

   @Test
   public void testInput14() throws Exception {

      Map<String, String> processEnvironment = new HashMap<>();
      processEnvironment.put("OUTPUT_PATH", createOutputPath("input14"));

      ProcessBuilder pb = prepareForExecution(ArrayManipulation2.class, "/arrman/input/input14.txt",
            processEnvironment);

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      logStdOutFromProcess(p);

      p.waitFor();

      log.info("Process ended");
   }

   @Test
   public void testInput00() throws Exception {

      Map<String, String> processEnvironment = new HashMap<>();
      processEnvironment.put("OUTPUT_PATH", createOutputPath("input00"));

      ProcessBuilder pb = prepareForExecution(ArrayManipulation2.class, "/arrman/input/input00.txt",
            processEnvironment);

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      logStdOutFromProcess(p);

      p.waitFor();

      log.info("Process ended");

   }

   @Test
   public void testInput15() throws Exception {

      Map<String, String> processEnvironment = new HashMap<>();
      processEnvironment.put("OUTPUT_PATH", createOutputPath("input15"));

      ProcessBuilder pb = prepareForExecution(ArrayManipulation2.class, "/arrman/input/input15.txt",
            processEnvironment);

      log.info("Starting process...");
      Process p = pb.start();
      log.info("Process started, waiting for completion");

      logStdOutFromProcess(p);

      p.waitFor();

      log.info("Process ended");

   }
}