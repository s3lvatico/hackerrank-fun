package org.gmnz.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        // int maxNpairs = (int) new Combinatorics().combinations(S.length, 2);
        // int[][] pairs = new int[maxNpairs][2];
        // int goodPairsSoFar = -1;

        Set<Integer> nonDividers = new HashSet<>();
        Set<Integer> blackList = new HashSet<>();

        /* doppio ciclo for per generare tutte le combinazioni */
        for (int i = 0; i < S.length - 1; i++) {
            if (blackList.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < S.length; j++) {
                if ((S[i] + S[j]) % k != 0) {
                    
                }
                else {

                }
            }
        }
        return nonDividers.size();
    }

    public static void main(String[] args) {
        NonDivisibleSubset nds = new NonDivisibleSubset();
        int rank = nds.nonDivisibleSubset(3, new int[] { 1, 7, 2, 4 });
        System.out.println(rank);
    }
}