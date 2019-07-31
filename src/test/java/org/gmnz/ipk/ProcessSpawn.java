package org.gmnz.ipk;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;


import org.junit.Test;

public class ProcessSpawn {

   @Test
   public void dummy() throws Exception {
      // ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir", "/s", "/b",
      // "target\\classes");
      ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", ArrayManipulation.class.getName());
      File f = new File(ProcessSpawn.class.getResource("/ipk/arrman/input/input14.txt").toURI());
      pb.redirectInput(f);
      pb.redirectOutput(Redirect.INHERIT);
      Process p = pb.start();
      // TimeUnit.SECONDS.sleep(2);
      p.waitFor();
      p.destroy();

   }
}