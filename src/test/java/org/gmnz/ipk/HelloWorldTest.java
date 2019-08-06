package org.gmnz.ipk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        HelloWorld hw = new HelloWorld();
        String expected = "Hello world";
        Assert.assertEquals(expected, hw.sayHello());
    }

    @Test
    public void passEnvVarToProcess() throws Exception {
        String envVarName = "OUTPUT_PATH";
        String outFileName = String.format("hwt-out-%d.txt", System.currentTimeMillis());
        StringBuilder sbOutFilePath = new StringBuilder(HelloWorldTest.class.getResource("/").toURI().getPath());
        sbOutFilePath.append(outFileName);

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", HelloWorldMain.class.getName());

        pb.environment().put(envVarName, sbOutFilePath.toString());

        pb.redirectErrorStream(true);
        System.out.println(pb.command());
        System.out.println(pb.environment());

        Process p = pb.start();

        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        try {
            String readLine;
            while ((readLine = r.readLine()) != null) {
                System.out.println(readLine);
            }
        } finally {
            r.close();
        }

        p.waitFor();
        System.out.printf("subprocess completed with exit code %d%n", p.exitValue());
    }

}