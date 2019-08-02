package org.gmnz.hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void factZero() {
        Factorial factorial = new Factorial();
        Assert.assertEquals(1, factorial.of(0));
        Assert.assertEquals(1, factorial.of(1));
        Assert.assertEquals(2, factorial.of(2));
        Assert.assertEquals(6, factorial.of(3));
        Assert.assertEquals(120, factorial.of(5));
    }
}