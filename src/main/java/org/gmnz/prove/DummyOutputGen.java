package org.gmnz.prove;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class DummyOutputGen {

    // private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        // TimeUnit.SECONDS.sleep(2);
        // log.info("---------- INITIATED! --------");
        System.out.println("---------- INITIATED! --------");
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " ::  I = " + i);
        }

    }

}