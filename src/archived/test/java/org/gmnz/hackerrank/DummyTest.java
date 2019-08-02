package org.gmnz.hackerrank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class DummyTest {

    private static final Logger log = LogManager.getLogger();

    @Test
    public void test() {
        log.info("dummyTest!");
        Assert.assertTrue(true);
        log.info("dummyTest superato");
    }

}