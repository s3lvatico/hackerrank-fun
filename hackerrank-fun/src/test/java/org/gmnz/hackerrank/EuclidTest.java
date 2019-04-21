package org.gmnz.hackerrank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * EuclidTest
 */
public class EuclidTest {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    @Test
    public void testMcd() {
        long l = Euclid.gcd(12, 8);
        Assert.assertEquals(4, l);

        l = Euclid.gcd(6, 12);
        Assert.assertEquals(6, l);

        l = Euclid.gcd(7, 5);
        Assert.assertEquals(1, l);
    }

}