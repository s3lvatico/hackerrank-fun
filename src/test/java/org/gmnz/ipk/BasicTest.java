package org.gmnz.ipk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class BasicTest {

   private static final Logger log = LogManager.getLogger();

   protected ProcessBuilder prepareForExecution(Class<?> targetClass, String strInputFileUrl,
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

   protected ProcessBuilder prepareForExecution(Class<?> targetClass, String strInputFileUrl)
         throws URISyntaxException {
      return prepareForExecution(targetClass, strInputFileUrl, null);
   }

   protected void logStdOutFromProcess(Process p) throws IOException {
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
}