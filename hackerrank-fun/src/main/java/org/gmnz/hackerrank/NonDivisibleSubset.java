package org.gmnz.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * NonDivisibleSubset
 */
public class NonDivisibleSubset {

    static class Factorial {

        private Map<Integer, Long> fMap = new HashMap<>();

        {
            fMap.put(0, 1L);
            fMap.put(1, 1L);
        }

        long of(int n) {
            if (!fMap.containsKey(n)) {
                fMap.put(n, n * of(n - 1));
            }
            return fMap.get(n);
        }

    }

    static class Combinatorics {

        long dispositions(int n, int k) {
            Factorial fact = new Factorial();
            return fact.of(n) / fact.of(n - k);
        }

        long combinations(int n, int k) {
            Factorial fact = new Factorial();
            long dispositions = dispositions(n, k);
            return dispositions / fact.of(k);
        }
    }

    /*
    
    
    */
    int nonDivisibleSubset(int k, int[] S) {
        int maxNpairs = (int) new Combinatorics().combinations(S.length, 2);
        int[][] pairs = new int[maxNpairs][2];

        int goodPairsSoFar = -1;

        for (int i = 0; i < S.length - 1; i++) {
            for (int j = i + 1; j < S.length; j++) {
                int x = S[i];
                int y = S[j];
                int sum = x + y;
                if (sum % k != 0) {
                    pairs[++goodPairsSoFar][0] = S[i];
                    pairs[goodPairsSoFar][1] = S[j];
                }
            }
        }
        return goodPairsSoFar + 1;
    }

    public static void main(String[] args) {
        NonDivisibleSubset nds = new NonDivisibleSubset();
        int rank = nds.nonDivisibleSubset(3, new int[] { 1, 7, 2, 4 });
        System.out.println(rank);
    }
}