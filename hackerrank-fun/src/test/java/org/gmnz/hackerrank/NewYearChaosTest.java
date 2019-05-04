package org.gmnz.hackerrank;

import org.junit.Assert;
import org.junit.Test;

/**
 * NewYearChaosTest
 */
public class NewYearChaosTest {

    @Test
    public void t0() {
        int[] q = new int[] { 1, 2, 3, 5, 4, 6, 7, 8 };
        Assert.assertEquals(1, NewYearChaos.minimumBribes(q));
    }

    // 1 2 5 3 7 8 6 4

    @Test
    public void t1() {
        int[] q = new int[] { 1, 2, 5, 3, 7, 8, 6, 4 };
        Assert.assertEquals(7, NewYearChaos.minimumBribes(q));
    }
    //

    @Test
    public void hrSampleTestCase1() {
        int[] q = new int[] { 5, 1, 2, 3, 7, 8, 6, 4 };
        Assert.assertEquals(-2, NewYearChaos.minimumBribes(q));
    }

    @Test
    public void hrSampleTestCase2() {
        int[] q = new int[] { 1, 2, 5, 3, 4, 7, 8, 6 };
        Assert.assertEquals(4, NewYearChaos.minimumBribes(q));
    }

}