package org.gmnz.hackerrank;

import org.junit.Assert;
import org.junit.Test;

/**
 * CombinatoricsTest
 */
public class CombinatoricsTest {

    @Test
    public void disp4_2() {
        Combinatorics c = new Combinatorics();
        long d_4_2 = c.dispositions(4, 2);
        Assert.assertEquals(12, d_4_2);
    }

    @Test
    public void comb4_2() {
        Combinatorics c = new Combinatorics();
        long d_4_2 = c.combinations(4, 2);
        Assert.assertEquals(6, d_4_2);
    }

}