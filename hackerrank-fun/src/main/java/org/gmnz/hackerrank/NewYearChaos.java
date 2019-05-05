package org.gmnz.hackerrank;

/**
 * NewYearChaos
 */
public class NewYearChaos {

    static int minimumBribes(int[] q) {

        /*
         * in questa versione provo un approccio iterativo
         */

        int l = q.length;

        int b = 0;

        for (int i = l - 2; i >= 0; i--) {
            int x = q[i];
            int jumps = 0;
            int j = i + 1;
            while (j < l) {
                if (x > q[j]) {
                    jumps++;
                }
                j++;
            }
            if (jumps > 2) {
                System.out.println("Too chaotic");
                return -2;
            } else {
                b += jumps;
            }
        }

        return b;
    }

}