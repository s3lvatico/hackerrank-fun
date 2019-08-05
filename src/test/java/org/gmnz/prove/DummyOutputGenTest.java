package org.gmnz.prove;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class DummyOutputGenTest {

    private static final Logger log = LogManager.getLogger();

    @Test
    public void someTest() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", DummyOutputGen.class.getName());

        File f = new File(DummyOutputGenTest.class.getResource("/arrman/input/input14.txt").toURI());
        log.debug("le file : " + f);
        log.debug("exists? : " + f.exists());
        pb.redirectInput(f);

        Process p = pb.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String readLine;
        while ((readLine = r.readLine()) != null) {
            log.info("line read from process' stdout :: " + readLine);
        }

        p.waitFor();

        p.destroy();

        r.close();

    }
}