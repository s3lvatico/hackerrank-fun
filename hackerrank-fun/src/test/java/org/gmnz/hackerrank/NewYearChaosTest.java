package org.gmnz.hackerrank;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

/**
 * NewYearChaosTest
 */
public class NewYearChaosTest {

    @Test
    public void sample1() {
        int[] q = new int[] { 2, 1, 5, 3, 4 };
        Assert.assertEquals(3, NewYearChaos.minimumBribes(q));
    }

    @Test
    public void sample2() {
        int[] q = new int[] { 2, 5, 1, 3, 4 };
        Assert.assertEquals(-2, NewYearChaos.minimumBribes(q));
    }

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

    @Test
    public void hrTestCase2Full() {

        InputStream in = NewYearChaosTest.class.getResourceAsStream("/nyc-hr-tc2.txt");
        final Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            Assert.assertEquals(966, NewYearChaos.minimumBribes(q));
        }

        scanner.close();

    }

    /*
     *
     * 
     * 
     * 
     * 
     * int[] q = new int[n];
     * 
     * String[] qItems = scanner.nextLine().split(" ");
     * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
     * 
     * for (int i = 0; i < n; i++) { int qItem = Integer.parseInt(qItems[i]); q[i] =
     * qItem; }
     * 
     * minimumBribes(q); }
     * 
     * scanner.close();
     */
}